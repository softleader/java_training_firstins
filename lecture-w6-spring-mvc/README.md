# Spring Data JPA
- Spring Data 是 SpringFramework 用以處理 ORM(Object-Relational Mapping) 的一個功能
- JPA(Java Persistence API) 是為 Java 針對持久化儲存的需求所訂定的一套介面
- 用以降低 Java 程式與 DB 之間的耦合度問題，與簡化 CRUD(Create, Read, Update, Delete) 的操作所需要撰寫的程式碼

## 預先準備
1. database:
    - 本範例以嵌入式的 MemoryDB: H2 作為 DB 使用
        > web-console: http://localhost:8080/h2
2. 於專案 `pom.xml` 加入 `spring-boot-starter-data-jpa` 依賴
    ```java
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```
    > 範例程式已有引入

## 設定 Datasource
- 設定檔位置: `./src/main/resources/application.properties`
- database相關:
    ```properties
    spring.datasource.driver-class-name=org.h2.Driver
    spring.datasource.url=jdbc:h2:file:~/test
    spring.datasource.username=sa
    spring.datasource.password=
    ```
- connection pool相關:
    ```properties
    spring.datasource.type=com.zaxxer.hikari.HikariDataSource
    spring.datasource.hikari.minimum-idle=5
    spring.datasource.hikari.maximum-pool-size=15
    spring.datasource.hikari.auto-commit=true
    spring.datasource.hikari.idle-timeout=30000
    spring.datasource.hikari.pool-name=DatebookHikariCP
    spring.datasource.hikari.max-lifetime=1800000
    spring.datasource.hikari.connection-timeout=30000
    ```

##

## 額外閱讀
1. [ORM介紹及ORM優點、缺點](http://www.cnblogs.com/xiaowuzi/p/3485302.html)
2. [JDBC(待補)]
3. [connection pool(待補)]
4. [SpringBoot2使用HikariCP的理由](http://blog.didispace.com/Springboot-2-0-HikariCP-default-reason/)
