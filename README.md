# 使用说明
## 一、如果要启动主程序需要依赖两个服务
1. weather service
2. postgres database
+ 可以cd到docker子目录运行：
####  `docker-compose up`
+ 其中weather service的容器镜像生成方式是：
+ cd到weatherservice子目录，运行：
####  `mvn clean package docker:build`

## 二、启动主程序的方式：
+ cd到springtesting，运行：
####  `mvn clean spring-boot:run`

## 三、如何在数据库中插入一条用户信息？
+ dos命令行运行:
####  `docker network ls`
+ 找到两个服务所在的网络名（如docker_default），然后运行：
#### `docker run -it --rm --net=docker_default postgres:9.5 psql -h database -p 5432  postgres -U testuser`
+ 输入口令password，这样，进入postgres客户端，然后运行sql命令：
#### `insert into person (id,first_name,last_name) values (1,'zhaosheng','tao');`

## 四、如何将主程序也部署到容器中？
+ cd到springtesting，制作镜像，运行：
####  `mvn clean package docker:build`
+ cd到docker子目录运行：
####  `docker-compose -f docker-compose-all.yml up`

## 五、调用例子
+ 直接调用原始天气服务
#### `http://localhost:8888/mykey/53.5511,9.9937`
+ 调用天气服务
#### `http://localhost:8080/weather`
+ 调用/hello
#### `http://localhost:8080/hello`
+ 调用/hello/{lastName}，存在
#### `http://localhost:8080/hello/tao`
+ 调用/hello/{lastName}，不存在
#### `http://localhost:8080/hello/tao2`