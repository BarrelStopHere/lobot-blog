启动所有停止的容器
docker start $(docker ps -a -q -f status=exited)

本地运行开启docker构建隧道
ssh -N -L 2375:localhost:2375 root@124.222.64.138

转移容器网段
docker network inspect example_default --format '{{range .Containers}}{{.Name}} {{end}}' | xargs -n1 docker network connect shared-net