# Week 2 Introduction for Java8 Lambda and Java Servlet (2018/08/22)

### Lambda 長什麼樣子? 它關心什麼？ 不關心什麼？
```java
public int normalFunction(int x) {
    return x * 3;
}

x -> x * 3
```
- 不關心目標型態 (因為有型別推斷)
- 不關心方法名稱 (實作方的角度)
- 不關心[Functional Interface](#何謂functional-interface)的名稱
- 只關心方法的實作

### 如何連結Java與Lambda？
- 在Java中與Lambda最相似的即Anonymous Class
  - 什麼是Anonymous Class?
  - 試著在Java中想要new一個Interface
### 使用Lambda的最佳時機？
- 當Anonymous Class剛好是[Functional Interface](#何謂functional-interface)時
### 使用Lambda有什麼好處？
- 更抽象、更共用(待會開始動手做時會演練)
- [簡化Anonymous Class的實作](#簡化anonymous-class的實作)、更專注於商業邏輯(呼叫方只需從方法命名即可掌握該流程) 



### JDK8 Functional API
- [實現Pipeline風格](#何謂pipeline風格)
- [閱讀API前必須知道的四大介面](#閱讀api前必須知道的四大介面)
- [誰可以使用Stream?](#誰可以使用stream)
- [Stream怎麼用?](stream怎麼用-java.util.stream.stream)
- [Stream 的 reduce 與 collect]()
- [處理null的好幫手 Optional](#處理null的好幫手-optional)


 
### 課後練習
- [試著使用Stream與Lambda語法實作商業邏輯](#試著使用stream與lambda語法實作商業邏輯)

* * *
* * *

## Lambda


### 簡化Anonymous Class的實作
-  使用匿名類別
```java
Collections.sort(students, new Comparator<Student>() {
	@Override
	public int compare(Student student1, Student student2) {
		return student1.getAge() - student2.getAge();
	}
});
```
- 使用Lambda
```java
Collections.sort(students, (student1, student2) -> student1.getAge() - student2.getAge()));
```



### 何謂Functional Interface?
- 恰/只有一個抽象方法的介面
- @FunctionalInterface
```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}
```

### 何謂Pipeline風格?
- 非Pipeline
```java
CustomizedHelperLikeType.map(
	CustomizedHelperLikeType.filter(
		CustomizedHelperLikeType.of(1, 2, 3)
	, condition)
, mapper);
```
- Pipeline
```java
CustomizedStreamLikeTypeImpl
.of(1, 2, 3)
.filter(condition)
.map(mapper)
.get()
```
### Pipeline化的好處
- 商業邏輯單元化: 測試、重組
- 流程與邏輯切割分明: 可讀性、維護


* * *

## Stream
### 誰可以使用Stream?
- 所有繼承自Collection的Class都能呼叫.stream()
    - 此方法可以將Collection<E>轉成Stream<E>
- 呼叫Stream.of(T t)或Stream.of(T... values)



### Stream怎麼用? java.util.stream.Stream
- 中介操作(Intermediate operation/Aggregate operation)
- 最終操作(Terminal operation)

| 方法名稱  | 描述         | 類型         |
|-----------|--------------|--------------|
| filter    | 過濾         | intermediate |
| map       | 轉型         | intermediate |
| flatMap   | 轉型         | intermediate |
| distinct  | 篩選出不重複 | intermediate |
| sorted    | 排序         | intermediate |
| forEach   | 列舉         | terminal     |
| reduce    | 壓縮         | terminal     |
| min       | 取最小       | terminal     |
| max       | 取最大       | terminal     |
| anyMatch  | 任一符合     | terminal     |
| allMatch  | 全部符合     | terminal     |
| findFirst | 取第一筆     | terminal     |
| collect   | 收集         | terminal     |



### 閱讀API前必須知道的四大介面
- [java.util.function.Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
  - input 轉變成 output 一般用於資料轉換
- [java.util.function.Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
  - input 轉變成 boolean 一般用於過濾資料
- [java.util.function.Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
  - 有input, 沒有output 一般用於顯示資料或者執行任務後不需再回傳的情境
- [java.util.function.Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
  - 沒有input, 有output 一般用於getter
- 比較「實作匿名類別」與「以Lambda語法實作」的差異  

### Stream 的 reduce 與 collect
- reduce 壓縮資料 一般用於加總
- collect 收集資料 一般會需呼叫Collectors現有的靜態方法(Ex: groupingBy, toList, toMap, ...)

### 處理null的好幫手 Optional
 - 建立方法 of(), ofNullable()
 - 使用方法 orElse(), orElseGet(), orElseThrow()
 - 比較差異 orElse(), orElseGet()
* * *

### 課後練習
### 試著使用Stream與Lambda語法實作商業邏輯
- 執行進入點 lambda.exercise.HumanResourceExecutor
- 商業邏輯   lambda.exercise.service.PersonService
- 資料物件   lambda.exercise.model.Person



 * * *
## Servlet life cycle
![servlet life cycle](https://www.tutorialspoint.com/servlets/images/servlet-lifecycle.jpg)
### Servlet 的生命週期 
|執行者|執行內容|被執行物件|頻率|
|-----|--------|----|----|
|Container|實例化Servlet||僅一次|
|Container|接到該Servlet的首次request時呼叫init()|Servlet|僅一次|
|Container|呼叫service()並根據擋頭判斷要呼叫Servlet的doGet()或是doPost()|Servlet|每次request都會呼叫|
|Container|呼叫destroy(), 通常在Container關閉時呼叫|Servlet|僅一次|
### Servlet首次request耗時較久的原因
Servlet首次接到request會先呼叫init(ServletConfig config)  
因為這個步驟會將初始資料設定到Servlet, 所以耗時較久
### 整個Context中Servlet只會被實例化一次
除了特殊例子(**SingleThreadModel**)外, 多個request呼叫同一Servlet時  
呼叫的都是同一個Servlet實例, Container會根據設定(可能從Threadpool取出)採用多個Thread呼叫.  
![非STM與STM](https://drive.google.com/uc?id=1DUXRApw6fiOuqDKe73ctv1508JIWOx48&authuser=0)
