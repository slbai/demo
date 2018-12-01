### Eureka 服务注册与发现
`eureka-client-user-api`公共模块

`eureka-client-user-service-consumer`服务消费者，通过调用注册中心的`服务生产者`来进行消费

`eureka-client-user-service-provider`服务生产者，操作数据库，并注册到注册中心，让其他消费模块使用

`eureka-server`注册中心，可以配置多个注册中心，互相注册。
