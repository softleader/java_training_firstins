# Week 2 Introduction for Java8 Lambda and Java Servlet (2018/08/22)

### Lambda 長什麼樣子? 它關心什麼？ 不關心什麼？
```java
public int f(int x) {
    return x * 3;
}

x -> x * 3
```
- 不關心函式介面的名稱
- 不關心目標型態 (因為有型別推斷)
- 不關心方法名稱 (實作方的角度)
- 只關心方法的實作

### 函數式程式設計有什麼好處？
- 更抽象、更共用(待會開始動手做時會演練)
- [簡化匿名類別的實作](#簡化匿名類別的實作)、更專注於商業邏輯(對呼叫方method命名很重要) 
- 更具可讀性([Pipeline風格](#何謂pipeline風格))

### 何謂Functional Interface?
- 只有一個抽象方法的介面
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

### JDK8 Functional API
- [閱讀API前必須知道的四大介面](#閱讀api前必須知道的四大介面)
- [誰可以使用Stream?](#誰可以使用stream)
- [Stream怎麼用?](stream怎麼用-java.util.stream.stream)
- [Stream 的 reduce 與 collect]()
- [處理null的好幫手 Optional](#處理null的好幫手-optional)


 
### [課後練習](#課後練習)

* * *
* * *

## Lambda


### 簡化匿名類別的實作
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
  - input 轉變成 output
- [java.util.function.Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
  - input 轉變成 boolean
- [java.util.function.Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
  - 有input, 沒有output
- [java.util.function.Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
  - 沒有input, 有output

### 處理null的好幫手 Optional
 - 建立方法 of(), ofNullable()
 - 使用方法 orElse(), orElseGet(), orElseThrow()
 - 比較差異 orElse(), orElseGet()
* * *
## Stream 與 Lambda

### 課後練習
- 執行進入點 lambda.exercise.HumanResourceExecutor
- 商業邏輯   lambda.exercise.service.PersonService
- 資料物件   lambda.exercise.model.Person
