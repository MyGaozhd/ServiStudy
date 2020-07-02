1、支持controller
2、支持Configuration，自定义bean
3、支持yaml(yml)文件配置
4、支持yml文件配置指定环境
spring:
  profiles:
    active: dev
5、支持继承配置
application-dev.yml-> application.yml
#设置支持访问 'http://localhost:8080/actuator/beans'
management:
  endpoints:
    web:
      exposure:
        include:
          - '*'