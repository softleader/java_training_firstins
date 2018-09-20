# Spring MVC
- 基於 Servlet API 的 Web Framework

## 預先準備
### 工具
- 本次會練習到HttpMethod，由於瀏覽器的一般功能無法直接呼叫GET以外的方法，為了方便測試需要額外的工具，這邊使用Chrome的plugin: Advanced Rest Client

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

### HTTP request/response 概念
1. Request:
    - <img src="./src/main/resources/templates/httprequest.png">
2. Response:
    - <img src="./src/main/resources/templates/httpresponse.png">

### 環境準備
> 範例程式已經完成此步驟
1. spring-mvc: 於專案 `pom.xml` 加入 `spring-boot-starter-web` 依賴
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```
    > 為了能練習一整套的MVC操作，範例程式亦引入了`spring-jpa`與`H2`

## 實作
### 第一個 Controller
- 範例: `com.example.firstinsmvc.web.MemberController`
- 元素:
    1. `@Controller`
        - 宣告於Class層
        - 表示該Class為SpringMVC的Controller
    2. `@RestController`
        - 同`@Controller`，但額外自帶`@ResponseBody`
        - 使該Controller的輸出符合RestfulApi規範
    3. `@RequestMapping`
        - 宣告於Class層或Method層
        - 表示該服務位於的網址
        - 其餘還有 `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` 等變種，差別僅在於HttpMethod的不同
    4. `@PathVariable`
        - 宣告於Mathod的input參數上
        - 表示參數與網址列中的{}變數進行對應
    5. `@RequestParam`
        - 宣告於Mathod的input參數上
        - 表示參數與RequestBody內的屬性對應
    6. `@RequestBody`
        - 宣告於Mathod的input參數上
        - 表示參數即是整個MessageBody
    7. `@ResponseBody`
        - 宣告於Mathod上或output上(效果相同)
        - 表示output即是MessageBody
- 練習:
    ```
    1. 撰寫一個RestController，命名為SampleContorller，並使其的路徑位於 http://localhost:8080/sample 下
    2. 增加一Method, 使於瀏覽器網址列呼叫 http://localhost:8080/sample/hello 時回應 world 文字
    3. 增加一Method, 使於瀏覽器網址列呼叫 http://localhost:8080/sample/hello?name={name} 時回應變數 name 裡面的文字
    4. 增加一Method, 使於瀏覽器網址列呼叫 http://localhost:8080/sample/hello/{name} 時回應變數 name 裡面的文字
    ```

### HttpMethod
- 較常用的分別有 GET, POST, PUT, DELETE
    - 用以區分同樣路徑下，不同的資源操作行為
- 於Restful風格下時
    - GET: 表示獲取資源，為預設值
    - POST: 表示新增資源
    - PUT: 表示修改資源
    - DELETE: 表示刪除資源
- 練習:
    ```
    於SampleContorller下
    1. 增加一Method, 使於ARC呼叫 POST http://localhost:8080/sample/hello body={"name" = "Rhys"} 時回應變數name的文字
    ```

### Controller and View
- 範例: `com.example.firstinsmvc.web.MemberController`, `member.html`
- 於畫面上打出Request給Controller:
    - 本範例使用 jQuery
    ```javascript
    // 查詢
    $('#query').on('click', e => {
        $.ajax({
            url: MEMBER_URL,
            method: 'GET'})
            .done((data, textStatus, jqXHR) => {
                // do something....
            });
    });
    ```
    - 元素:
        1. `$('#query')`: 表示從http元素中取得id=query者
        2. `.on('click', function() {})`: 表示當該元素觸發click事件時，執行function
        3. `$.ajax`: 呼叫AjaxRequest
            - `url`: 呼叫目標網址
            - `method`: 呼叫目標的HttpMethod
    ```javascript
    // 新增/修改
    $('#save').on('click', e => {
        $.ajax({
            url: MEMBER_URL,
            data: JSON.stringify($('#form').toObject()),
            contentType: 'application/json; charset=UTF-8',
            method: $('#id').val() ? 'PUT' : 'POST'})
            .done((data, textStatus, jqXHR) => {
                $('#id').val(data.id);
            });
    });
    ```
    - 元素:
        1. `$.ajax`
            - `data`: 即是Request Message Body
            - `contentType`: 描述data的格式
- 練習:
    ```
    1. 增加AGE欄位，並修改相對應的新刪修查功能
    2. 新增一套關於Role的功能，資料欄位要有Code(代號)與Name(中文名稱)與Desc(說明)，可以複製Member進行修改
    ```

## 額外閱讀
- [跨來源資源共用](https://developer.mozilla.org/zh-TW/docs/Web/HTTP/CORS)
