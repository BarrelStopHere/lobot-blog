docker run -d --name rbbitmq3.8.7 -p 5672:5672 -p 15672:15672 \
-v /server/app/rabbitmq/ --hostname myRabbit \
-e RABBITMQ_DEFAULT_VHOST=my_vhost \
-e RABBITMQ_DEFAULT_USER=admin \
-e RABBITMQ_DEFAULT_PASS=admin 5726af297dd4