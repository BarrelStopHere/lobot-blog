启动所有停止的容器
docker start $(docker ps -a -q -f status=exited)
