# Spring MVC
- 基於 Servlet API 的 Web Framework

## 預先準備
### MVC概念

<img src="./src/main/resources/templates/MVC-Process.svg" height="500">

1. MVC模式: 全名Model–View–Controller，是一種通用的設計模式
    - 將系統分為三個基礎部分: 模型（Model）、視圖（View）、控制器（Controller）
    - 目的是使介面設計人員與軟體設計人員能專注在自己工作的範疇不互相影響
2. MVC分工
    - Controller: 負責轉發請求，對請求進行處理
    - View: 負責UI介面的設計
    - Model: 負責商業邏輯的實作，包含資料庫資料處理
3. 傳統的 MVC on Java
    - Controller, Model: 以Java Class進行實作
    - View: 以Jsp進行實作
### 環境準備
> 範例程式已經完成此步驟
1. spring-mvc: 於專案 `pom.xml` 加入 `spring-boot-starter-web` 依賴
    ```java
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
    ```
    > 為了能練習一整套的MVC操作，範例程式亦引入了`spring-jpa`與`H2`

## 實作
### 第一個 Controller
