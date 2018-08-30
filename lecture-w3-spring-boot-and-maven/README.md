# Spring Boot and Maven

## Prerequisite

- Maven installed (3.5 or above):

```
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

```
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

```
mvn spring-boot:run
```

## Logging


- [Spring Boot Dependency versions](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#appendix-dependency-versions)
- [Common application properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#common-application-properties)



