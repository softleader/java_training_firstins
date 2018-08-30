# Spring Boot and Maven

## Prerequisite

- Maven installed (3.5 or above):

```sh
mvn -version
```

> 若尚未安裝請繼續往下參考 [Install Maven](#install-maven) 章節

### Install Maven

- 點擊[下載 Maven](https://maven.apache.org/download.cgi)
- 設定 `JAVA_HOME`
- 設定 `MAVEN_HOME` 以及 `M2_HOME`

> Maven document said add M2_HOME only, but some programs still reference Maven folder with MAVEN_HOME, so, it’s safer to add both.

## Getting Started

Spring Boot 協助你快速建置 Stand-alone, Production-grade 的 Spring based Applications, 你只需要 *"run"*

> [http://spring.io/projects/spring-boot](http://spring.io/projects/spring-boot)

- Spring Framework
	- Spring Bean
	- Spring AOP
	- Spring MVC
- Spring Data JPA
- Spring Security*
- Spring Session*

> 打 * 的 Spring 專案偏向一致性的底層架構建置, 與開發業務邏輯較無關聯, 故不收錄在本 8 週的集訓課程中

### Bootstrap a Spring based Application

1. Spring Boot 專案產生器: [https://start.spring.io/](https://start.spring.io/)
1. 輸入 Project Metadata
	- *Group* - `tw.com.firstins`
	- *Artifact* - `week3`
1. 選擇所需的 Dependencies
1. 點擊 Generate Project 產生專案

### Directory Layout

```sh
.
├── pom.xml            >> Project Object Model
└── src
    ├── main
    │   ├── java       >> application sources
    │   └── resources  >> application resources
    └── test
        ├── java       >> test sources
        └── resources  >> test resources
```

- [What is the POM?](https://maven.apache.org/pom.html#What_is_the_POM)

### Just Run

```sh
cd <project-directory>

# 啟動 server
mvn spring-boot:run

# ctrl + c to exit
```

## application.properties

所有設定可以透過 `application.properties` 快速更改, 請參考官方文件: [Common application properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#common-application-properties) 找到想調整的參數

## Hello World

1. 以 maven 專案匯入你的 IDE
1. 建立 package: `tw.com.firstins.week3.web`
1. 建立 class: `tw.com.firstins.week3.web.IndexController`

### @Bean

1. 建立 package: `tw.com.firstins.week3.service`
1. 建立 class: `tw.com.firstins.week3.service.HelloWorldService`

## Logging

1. 在 `HelloWorldService` 寫一些 debug 訊息
2. 調整 `application.propertie` 將 debug 訊息也印出吧

## Packaging

```sh
cd <project-directory>

# 打包
mvn package

# 打包過程的暫存目錄
cd target

# 執行
java -jar week3-0.0.1-SNAPSHOT.jar
```

### How to deploy to Tomcat?

1. Download tomcat 8.5 from [tomcat.apache.org](https://tomcat.apache.org/download-80.cgi#8.5.33)
1. Change the packaging from `jar` to `war` in `pom.xml`
1. Add `SpringBootServletInitializer` to your main class
1. Packaging again!

## Appendix

- [Spring Boot Dependency versions](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#appendix-dependency-versions)



