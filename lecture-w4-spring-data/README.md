# Spring Data JPA
- Spring Data 是 SpringFramework 用以處理 ORM(Object-Relational Mapping) 的一個功能
- JPA(Java Persistence API) 是為 Java 針對持久化儲存的需求所訂定的一套介面
- 用以降低 Java 程式與 DB 之間的耦合度問題，與簡化 CRUD(Create, Read, Update, Delete) 的操作所需要撰寫的程式碼

## 預先準備
### 環境準備
> 範例程式已完成此步驟
1. database: 本範例以嵌入式的 MemoryDB: H2 作為 DB 使用
    - web-console: http://localhost:8080/h2
    - document: http://www.h2database.com/html/features.html
2. spring-data: 於專案 `pom.xml` 加入 `spring-boot-starter-data-jpa` 依賴
    ```java
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```

### 設定 Datasource
- 設定檔位置: `./src/main/resources/application.properties`
- database相關:
    ```properties
    spring.datasource.driver-class-name=org.h2.Driver
    spring.datasource.url=jdbc:h2:mem:TEST
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
- 於Java中啟動
    - `@EnableJpaRepositories`
        > 由於本範例引入了 JPA starter, 這件事已經在`JpaRepositoriesAutoConfiguration`做過
        > (透過`@Import({JpaRepositoriesAutoConfigureRegistrar.class})`)

## 實作
### JDBC練習
- `練習`
    ```
    com.example.firstins.member.MemberDaoTest.jdbcExample
    1. 完成 Query By Name
    2. 完成 Update
    3. 完成 Delete
    ```
    > 撰寫時須注意: Connection, PreparedStatement, ResultSet 等 jdbc 物件需要 close()
- `測試`
    1. 執行 com.example.firstins.member.MemberDaoTest.jdbcExample

### 建置Entity
- 範例: `com.example.firstins.member.entity.Member`
- 前置
    1. 準備一個要做為Table映射的Pojo Class
    2. ClassName對應TableName、FieldName對應ColumnName
- 必要
    - `@Entity`
        - 宣告於Class上
        - 向Spring宣告該Class是一個Entity
    - `@Id`
        - 宣告於Field上
        - 表示該Field為此Entity的PrimaryKey
    - `@Column`
        - 宣告於Field上
        - 表示該Field為此Entity需要映射到Table上的欄位
        - 自帶預設的ORM規則，若有需要覆寫(如映射的ColumnName)，則參考此Annotation內的屬性描述

- 額外
    - `@GeneratedValue`
        - 宣告於Field上
        - 告訴此Column的生成方式，預設為GenerationType.AUTO讓容器來自動產生(通常是流水號)
    - `@PrePersist`
        - 宣告於method上
        - 於進行Insert處理前執行此method
    - `@PreUpdate`
        - 宣告於method上
        - 於進行Update處理前執行此method
    - `@MappedSuperclass`
        - 宣告於Class上
        - 向Spring宣告該Class是一個抽象的Entity(通常用於每個Table共通的欄位)
    - `@Table`
        - 宣告於Class上
        - 需要覆寫`@Entity`預設的ORM規則時會使用
> Spring真對Entity有一套預設的ORM規則，以命名而言，都是根據駝峰命名轉大寫並以底線區隔做為TableName或ColumnName
- `練習`
    ```
    com.example.firstins.member.Member
    1. 增加Age欄位
    2. 設定Age欄位的長度為3位數
    3. 設定Name欄位為Unique
    4. 設定Name欄位為NonNull

    com.example.firstins.member.Address
    1. 建立一個地址的Entity，Field至少要有郵遞區號、城市、行政區、地址
    ```
- `測試`
    1. 啟動 com.example.firstins.LectureW4SpringDataApplication.main
        > 由於有引入 spring-web 的緣故，會自動以嵌入式的 tomcat 啟動
    2. 透過 [h2 console](http://localhost:8080/h2) 進行 SQL 指令操作

### 建置Dao
- 範例: `com.example.firstins.member.dao.MemberDao`
- 前置:
    1. 準備一個interface並繼承`org.springframework.data.jpa.repository.JpaRepository`
    2. `JpaRepository`的泛型宣告Entity型別與ID型別
    > 繼承了`JpaRepository`後Spring便會於啟動時進行實作，可以用`@AutoWired`取得之，且有擁有基本的CRUD功能
- 撰寫查詢語句
    - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    - 例: 以Member.name查詢
        - `List<Member> findByName(String name);`
- 進階的查詢方式
    - JPQL
    - NativeSQL
- `練習`
    ```
    com.example.firstins.member.MemberDaoTest.jpaExample
    1. 練習一套基本的crud

    com.example.firstins.member.MemberDao
    1. 增加以age進行查詢的方法
    2. 增加以區間查詢age的方法(例: 查詢18~24歲的人)

    com.example.firstins.member.AddressDao
    1. 建立地址的entity的dao，並寫test確保能正常運行
    ```
- `測試`
    1. 於 com.example.firstins.member.MemberDaoTest.jpaExample 撰寫測試程式，並啟動之
    2. 利用 System.out.println 驗證

## 附錄
### 額外補充: Hibernate Session
- Hibernate的Entity存在三種狀態
    - transient
        > 透過 new 語句產生的新物件，尚未進入db
    - persistent
        > 透過 query 語句從db撈出的物件
        > 對其的任何 set 操作皆會在 session 結束後推入至db
    - detached
        > 透過 query 語句從db撈出的物件，但已經脫離 session 範圍

### 深入閱讀
1. [Spring Data JPA - Projects](https://projects.spring.io/spring-data-jpa/)
2. [ORM介紹及ORM優點、缺點](http://www.cnblogs.com/xiaowuzi/p/3485302.html)
3. [connection pool(HikariCP)](https://www.baeldung.com/hikaricp)
4. [SpringBoot2使用HikariCP的理由](http://blog.didispace.com/Springboot-2-0-HikariCP-default-reason/)
