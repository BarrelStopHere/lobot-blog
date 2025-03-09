docker run -d \
--name my-redis \
-p 6379:6379 \
-v /etc/docker/redis/redis.conf:/usr/local/etc/redis/redis.conf \
redis redis-server /usr/local/etc/redis/redis.conf