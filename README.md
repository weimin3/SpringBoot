SpringBoot
# 1. 基础篇
- 学习目标：
  1. 能够创建SpringBoot工程
  2. 基于SpringBoot实现ssm整合
## 1.1 快速上手SpringBoot
1. 实例【[CODE](springboot_01_01_quickstart/src/main/java/com/example)】
* 说明：最简单的SpringBoot程序包含的基础文件是：
  1. pom.xml文件
  2. Application类
* 步骤
  1. 新建module,选择 spring initializr, 并配置模块相关基础信息
  2. 选择当前模块需要使用的技术集。比如：web- spring web
  3. 开发了一个MVC控制器 "controller - BookController"
  4. 运行自动生成的application类， 即"Springboot0101QuickstartApplication"， 运行结果有服务器端口等信息
  5. 在浏览器中输入访问地址访问：http://localhost:端口号/controller中@RequestMapping()括号内的信息

* 实例解析：实例能运行依赖如下组建 pom.xml文件内容（parent和starter）
  - parent：spring - boot - starter - parent 各版本间存在着诸多坐标版本不同，定义了若干个坐标版本好（依赖管理，而非依赖），继承了dependence，方便配置，做版本管理，以达到减少依赖冲突的目的
  - starter：使用parent的内容 spring - boot - starter - web.pom, 定义了当前项目使用的所有依赖坐标，以达到减少依赖配置的目的
  - 引导类： 是boot工程的执行入口，运行main方法就可以启动项目，工程运行后初始化spring容器，扫描引导类所在包加载bean
  - 内嵌tomcat: Jetty比tomcat更轻量级，可拓展性更强。 内置服务器：tomcat:应用面广，负载若干较重的组件。 jetty：更轻量级，负载性能远不及tomcat.undertow:负载性能勉强跑赢tomcat
* 小技巧：
- idea中隐藏指定文件或指定类型文件：Setting -> File Types -> Ignored Files and Folders  输入要隐藏的文件名，支持*通配符，回车确认
- 使用任意坐标时，仅书写GAV中的G和A，V由SpringBoot提供，除非其未提供对应版本V，如发生坐标错误，再指定Version(要小心奔波冲突)
2. SpringBoot优点
- 起步依赖（简化依赖配置）
- 自动匹配（简化常用工程相关配置）
- 辅助功能（内置服务器）

## 1.2 REST开发
1. REST简介
- 定义：表现形式状态转换，即：访问网络资源的格式。
- 资源描述形式的不同：
  - 传统风格： http://localhost/user/getById?id=1
  - REST风格资源描述形式：http://localhost/user/1  
- 优缺点：
    - 1. 隐藏资源的访问行为，无法通过地址得知对资源是如何操作
    - 2. 书写简化
- REST风格简介：按照REST风格访问资源时使用**行为动作**区分对资源进行了何种操作
  - http://localhost/users  查询全部用户信息 GET(查询)
  - http://localhost/users/1  查询指定用户信息 GET(查询)
  - http://localhost/users  添加用户信息 POST(新增/保存)
  - http://localhost/users  修改用户信息  PUT(修改/更新)
  - http://localhost/users/1  删除用户信息  DELETE(删除)
  - 根据REST风格对资源进行访问称为RESTful 

## 1.2 SpringBoot基础配置
- 如何复制工程？（原则：保留工程基础结构，抹掉原始工程痕迹）
  - 进入到保存工程文件的目录中， 复制一个工作作为模块 
    - 打开pom.xml,修改<artifactId>
    - 删除文件，只留下src和pom.xml
  1. 属性配置（官方文档spring boot reference document -> Application properties查看）
- 修改服务器端口，resource -> application.properties 中 server.por = 80 例如：将http://localhost:8080/books 改为 http://localhost/books
- 修改banner(比如关闭),resource -> application.properties 中 spring.main.banner-mode= off  
2. 配置文件分类:同时存在，相同配置按照加载优先级相互覆盖，不同配置文件中不同配置全部保留
- .properties
  - server.port = 80
- .yml(主要用这种)
  - port： 81
- .yaml
  - port： 82
3. yaml文件
拓展名两种：.yml;.yaml
* yaml语法规则：(重点：数据前面要加空格与冒号隔开)
  - 大小写敏感
  - 属性层级关系使用多行描述，每行结尾使用冒号结束
  - 使用缩进表示层级关系，同层级左侧对齐，只允许使用空格（不允许使用Tab）
  - 属性值前面添加空格（属性名与属性值之间使用冒号+空格作为分隔）
  - "#"表示注释
  - 字面值表示方式：
    - boolean: true/TRUE/True
    - float: 3.14
    - int: 123
    - null: ~
    - string: helloworld/"helloworld"
    - date: 2023-02-25
    - datetime: 2023-02-25T15:02:31+08:00 #时间和日期之间使用T连接，最后使用+代表时区
4. yaml数据读取
- 写在controller中写
  - 读取yaml数据中的单一数据：
  ```
  # 一级数据
  @Value("${country}") #yaml中country: china
  private String c;
  
  # 多级数据
  @Value("${user.name}") #yaml中user有属性name，age等
  private String name; 
  
  # 数组数据
  @Value("${hobby[0]}") #yaml中hobby有属性[dance,music,writing]
  private String hobby1;#传入dance值
  ```
  - 读取全部属性数据
  ```
  # 使用自动装配将所有的数据封装到一个对象Environment
  @Autowired
  private Environment env;
  # 数据读取
  System.out.pringln(env.getProperty("user.name"))
  ```
  - 读取引用类型数据
  ```
  # 数据之间的相互引用
  baseDir: c:/windows
  #使用${属性名}引用数据
  tempDir: ${baseDir}\temp # 注意"${baseDir}\temp"和${baseDir}\temp是不一样的，"${baseDir}\temp"中\t是制表符
  
  datasource:
     
  ```
  
  


```
## 1.3 基于SpringBoot实现SSM整合


# 2. 实用篇 
## 2.1 运维
- 学习目标：
  1. 能够掌握SpringBoot程序多环境开发
  2. 能够基于Linux系统发布SpringBoot工程
  3. 能够解决线上灵活配置SpringBoot工程的需求
## 2.2 开发
- 学习目标：
  1. 能够基于SpringBoot整合任意第三方技术




