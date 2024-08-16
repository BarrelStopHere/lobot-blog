## 安装

### 下载镜像

```bash
wget https://github.com/docker/compose/releases/download/v2.16.0/docker-compose-linux-x86_64
```

### 移动下载软件到/usr/local/bin/docker-compose覆盖旧版本：

```bash
mv docker-compose-linux-x86_64 /usr/local/bin/docker-compose
```

### 赋予执行权限：

```bash
chmod +x /usr/local/bin/docker-compose
```

### 测试安装是否成功：

```bash
docker-compose --version
```

### 卸载docker compose：

```bash
rm -f /usr/local/bin/docker-compose
```

### 配置文件

```yaml
version: "3.9"
  services:
    web:
      build: .
      ports:
        - "8000:5000"
      volumes:
        - .:/code
        - logvolume01:/var/log
      links:
        - redis
    redis:
      image: redis
volumes:
  logvolume01: {}
```

```yaml
文件配置解释说明：

version：指定 Compose 文件格式yaml的规则版本，版本决定可用的配置选项
service：定义了应用中的服务，每个服务可以使用不同的镜像、环境设置和依赖关系
web：自己构建的镜像
build：用于构建镜像，指定构建镜像的 dockerfile 的上下文路径
ports：映射容器和宿主机的端口
volumes：挂载本地目录到指定容器目录，用于数据持久化或在容器之间共享数据
links：与redis服务连接
redis：构建指定镜像redis
image：从指定的镜像中启动容器，可以是存储仓库、标签以及镜像 ID
volumes：用于数据持久化和共享的数据卷定义，常用于数据库存储、配置文件、日志等数据的持久化
```

## 使用

### 创建应用程序和依赖项

```bash
mkdir counter-app-master    #创建测试目录
cd counter-app-master
vim app.py    #创建名为app.py的文件
```

```python
import time
import redis
from flask import Flask
 
app = Flask(__name__)
cache = redis.Redis(host='redis', port=6379)
 
def get_hit_count():
    retries = 5
    while True:
        try:
            return cache.incr('hits')
        except redis.exceptions.ConnectionError as exc:
            if retries == 0:
                raise exc
            retries -= 1
            time.sleep(0.5)
 
@app.route('/')
def hello():
    count = get_hit_count()
    return "What's up Docker Deep Divers! You've visited me {} times.\n".format(count)
 
if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True)
```

上述此示例中，redis 是应用程序网络上的 redis 容器的主机名，所以使用默认端口6379。

在测试目录中创建名为 requirements.txt 的文件：

```bash
cat requirements.txt
```

```txt
flask
redis
```

### 编写Dockerfile文件：

```bash
cat Dockerfile
```

```file
FROM python:3.6-alpine
ADD . /code
WORKDIR /code
RUN pip install -r requirements.txt
CMD ["python", "app.py"]
```

Dockerfile文档逐行解释说明：

- 从 Python 3.6 镜像开始构建
- 将当前目录拷贝到容器/code目录下
- 定义容器工作目录为/code
- 安装 Python 依赖项
- 容器默认执行命令

### 编写docker-compose.yml文件定义服务：

```bash
cat docker-compose.yml
```

```yaml
version: "3.5"
services:
  web-fe:
    build: .
    command: python app.py
    ports:
      - target: 5000
        published: 5000
    networks:
      - counter-net
    volumes:
      - type: volume
        source: counter-vol
        target: /code
  redis:
    image: "redis:alpine"
    networks:
      counter-net:
 
networks:
  counter-net:
 
volumes:
```

一级key解释说明：

version：定义 compose 文件格式的版本
services：定义不同的应用服务，上述定义web前端服务以及redis缓存数据库服务。Docker compose会将每个服务部署为一个容器，且会将key作为容器名字的一部分
networks：创建新的网络，默认自动创建bridge网络。此网络只能实现与同一主机容器连接
volumes：创建新卷

二级key解释说明：

web-fe服务指令解释说明：

build：. 代表基于当前目录，. 下Dockerfile中定义的指令构成一个新镜像，该镜像将被用于启动该服务的容器
command：在容器中执行名为app.py的Python脚本作为主程序，所以在Dockerfile中将满足镜像中包含app.py及Python
ports：容器内的5000端口映射到主机5000端口
networks：指定服务连接的网络，且指定的网络需要存在，或是在一级key中的networks中定义过
volumes：将counter-vol卷挂载到容器/code，且指定卷counter-vol需要存在，或是在一级key中的volumes中定义过
redis服务指定解释说明：

image：基于redis:alpine镜像启动一个独立名为redis的容器
networks：配置redis容器连接counter-net网络

```bash
docker-compose up     #前台启动
docker-compose up -d  #后台启动
```

## 常用命令

### 启动服务：

```bash
docker-compose up    #在前台启动服务

docker-compose up -d    #启动服务在后台运行

docker-compose up --build    #重新构建服务
```

### 停止并移除服务、网络、卷和默认镜像：

```bash
 docker-compose down    #停止并移除服务

 docker-compose down -v    #停止服务并移除卷
```

### 暂停服务：

```bash
 docker-compose pause
```

### 取消暂停服务：

```bash
docker-compose unpause
```

### 查看服务日志：

```bash
docker-compose logs    #查看所有服务日志

docker-compose logs -f    #实时查看日志
```

### 启动服务：

```bash
docker-compose start
```

### 停止服务：

```bash
docker-compose stop
```

### 重启服务：

```bash
 docker-compose restart
```

### 查看当前服务状态：

```bash
docker-compose ps
```

### 进入后台运行的容器：

```bash
docker-compose exec 容器名 /bin/sh
```

### 拉取镜像：

```bash
docker-compose pull
```

### 构建镜像：

```bash
docker-compose build
```

### 删除或停止容器：

```bash
docker-compose rm
```

### 本地系统和容器之间复制文件/文件夹：

```bash
docker-compose cp
```

