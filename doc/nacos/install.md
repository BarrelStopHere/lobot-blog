## 前言
安装之前你需要准备一个mysql，当前安装方式是将数据持久化到数据库中的，这里的部署是单机模式
## 1、Docker 拉取镜像
```bash
docker pull nacos/nacos-server
```


PS：这是拉取最新的nacos版本，如果需要拉取别的版本可以加：版本号（如：docker pull nacos/nacos-server:v2.2.0）

## 2、挂载目录
```bash
mkdir -p /mydata/nacos/logs/                      #新建logs目录
mkdir -p /mydata/nacos/conf/					  #新建conf目录
```

PS：这一步是添加映射文件夹，将宿主机的文件映射到nacos容器中

## 3、启动nacos并复制文件到宿主机，关闭容器
### 启动容器
```bash
docker run -p 8848:8848 --name nacos -d nacos/nacos-server
```


### 复制文件
```bash
docker cp nacos:/home/nacos/logs/ /mydata/nacos/
docker cp nacos:/home/nacos/conf/ /mydata/nacos/
```

### 关闭容器
```bash
docker rm -f nacos
```


PS：这一步启动nacos是为了将nacos里面的文件拷贝出到挂载目录中，这样我们就可以直接修改挂载目录中文件来映射到容器里面去了

## 4、mysql中创建nacos所需的表
mysql中新建一个库，名字可自定义，这里就用nacos-config
从github中找到创建表的文件，在nacos-config库中执行，创建所需的表

## 5、再次启动nacos
``` bash
docker run -d
--name nacos															 
-p 8848:8848  -p 9848:9848 -p 9849:9849
--privileged=true
-e JVM_XMS=256m
-e JVM_XMX=256m
-e MODE=standalone
-v /mydata/nacos/logs/:/home/nacos/logs
-v /mydata/nacos/conf/:/home/nacos/conf/
--restart=always
nacos/nacos-server
```

PS : 复制上面的语句执行失败，可以将上面的执行语句变成一行，如下，可直接复制执行
```bash
docker run -d --name nacos -p 8848:8848  -p 9848:9848 -p 9849:9849 --privileged=true -e JVM_XMS=256m -e JVM_XMX=256m -e MODE=standalone -v /mydata/nacos/logs/:/home/nacos/logs -v /mydata/nacos/conf/:/home/nacos/conf/ --restart=always nacos/nacos-server
```

### 语句讲解

docker run -d ： 启动容器 -d是后台启动并返回容器id的意思
–name nacos ：为容器指定一个名称
-p 8848:8848 -p 9848:9848 -p 9849:9849 ： 指定端口映射，注意这里的p不能大写，大写是随机端口映射
–privileged=true ： 扩大容器内的权限，将容器内的权限变为root权限，不加的话就是普通用户权限，可能会出现cannot open directory
-e JVM_XMS=256m ： 为jvm启动时分配的内存
-e JVM_XMX=256m ： 为jvm运行过程中分配的最大内存
-e MODE=standalone ： 使用 standalone模式（单机模式）,MODE值有cluster（集群）模式/standalone模式两种，MODE必须大写
-v /mydata/nacos/logs/:/home/nacos/logs : 将容器的/home/nacos/logs目录挂载到 /mydata/nacos/logs
-v /mydata/nacos/conf/:/home/nacos/conf/： 将容器的/home/nacos/conf目录挂载到 /mydata/nacos/conf
–restart=always ：重启docker时，自动启动相关容器

### 注意事项

需要在防火墙开放相关端口，如果你是云服务器，开放安全组，下面提供相关语句

#### 开放端口8848 9848 9849
```bash
firewall-cmd --zone=public --add-port=8848/tcp --permanent
firewall-cmd --zone=public --add-port=9848/tcp --permanent
firewall-cmd --zone=public --add-port=9849/tcp --permanent
```

#### 重启防火墙
```bash
firewall-cmd --reload
```

#### 查看所有开启的端口
```bash
firewall-cmd --zone=public --list-ports
```

PS：这里有点小问题，重启完防火墙之后，需要重启docker

## 重启docker
```bash
systemctl restart docker
```

这里最容易犯错的就是挂载目录对应不上，可以看下自己语句中的-v 后面的目录是否映射正确，博主第一次安装的时候logs里面还有一个logs文件夹，conf里面还有个conf文件夹，导致出错

## 6、修改配置文件
主要修改的是application.properties文件
### 在宿主机中修改application.properties文件
```bash
vim /mydata/nacos/conf/application.properties
```

### 文件修改的地方（修改为你对应的mysql）

```bash
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://localhost:3306/nacos-config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=30000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=root
```

PS ：因为我们在第三步已经复制了logs和conf到了我们的宿主机里面，那么我们可以直接修改application.properties文件映射到容器里，可以通过下面的语句来查看

### 进入到nacos容器里
```bash
docker exec -it nacos /bin/bash
```

### 查看application.properties文件
```bash
cat /home/nacos/conf/application.properties
```

### 退出容器
```bash
exit
```

PS：如果文件没有修改成功的话，说明挂载目录映射的不对，仔细查看一下，可以通过下面的方法来查看是否正确
```bash
docker inspect --format="{{json .Mounts}}" nacos
```

## 7、访问页面

http://ip:8848/nacos/index.html
