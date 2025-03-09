mkdir -p /usr/docker/nginx/html
mkdir -p /etc/docker/nginx/{conf.d,logs}
创建宿主机的挂载目录

docker run \
  --name nginx \
  -itd -p 80:80 --net host \
  -v /usr/docker/nginx/html:/usr/share/nginx/html \
  -v /etc/docker/nginx/nginx.conf:/etc/nginx/nginx.conf:ro \
  -v /etc/docker/nginx/conf.d:/etc/nginx/conf.d \
  nginx
  启动容器并把容器配置挂载出来到宿主机

docker cp f9da8618bd9e:/etc/nginx/nginx.conf /etc/docker/nginx/nginx.conf
docker cp f9da8618bd9e:/etc/nginx/conf.d/default.conf /etc/docker/nginx/conf.d/default.conf
复制容器中的原始配置文件到宿主机方便首次启动

docker run --name nginx -d -p 80:80 -v /usr/docker/nginx/html:/usr/share/nginx/html nginx
