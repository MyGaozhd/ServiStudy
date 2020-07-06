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
6、支持增加访问路径
 server:
   port: 8080
   servlet:
     #设置访问路径
     context-path: /servi
7、支持优先级目录
 config\application.yml
8、注册servlet
com.servi.study.boot.config.servlet.ServiServletConfiguration
9、注册filter
com.servi.study.boot.config.filter.ServiFilterConfiguration
10、注册ServletContextListener
com.servi.study.boot.config.servlet.ServiServletConfiguration
11、logback日志格式修改
logback-spring.xml
            <springProfile name="!dev">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ----> [%thread] ---> %-5level %logger{50} - %msg%n</pattern>
            </springProfile>
            <springProfile name="dev">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} -> [%thread] -> %-5level %logger{50} - %msg%n</pattern>
            </springProfile>
12、自动执行数据库建库脚本
DataSourceInitializer.initSchema->isEnabled->isEmbedded()->
EmbeddedDatabaseConnection.IsEmbedded.doInConnection(回调方法)
->EmbeddedDatabaseConnection.values() 枚举里面不包括mysql
13、集成阿里巴巴druid数据源
http://localhost:8081/servi/druid/index.html
14、增加mybatis支持
C04_Controller
15、增加jpa支持
C05Controller
16、增加监听器
com.servi.study.boot.listener.ServiApplicationContextInitializer
com.servi.study.boot.listener.ServiSpringApplicationRunListener
com.servi.study.boot.listener.ServiApplicationRunner
com.servi.study.boot.listener.ServiCommandLineRunner