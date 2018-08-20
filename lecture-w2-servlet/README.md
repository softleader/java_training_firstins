# Week 2 Introduction for Java8 Lambda and Java Servlet (2018/08/22)

### Lambda關心什麼？ 不關心什麼？
```
f(x) = x * 3
x -> x * 3
```
- 不關心函式介面的名稱
- 不關心目標型態 (因為有型別推斷)
- 不關心方法名稱 (Lambda運算式是匿名方法)
- 只關心方法的簽署(signature) (Lambda運算式的本體就是函式介面的方法實作)

### 函數式程式設計有什麼好處？
- 更抽象([基本的Lambda演算](#基本的lambda演算))、更共用
- [簡化匿名類別的實作](#簡化匿名類別的實作)、更專注於商業邏輯 
- 更具可讀性([管線操作風格](#何謂管線操作風格))

### 不是函數式語言 Java8如何引入? 增加型態? 
- Java 8 沒有加入新的函式型態
- 取而代之的是而是使用[抽象方法介面](#何謂抽象方法介面functional-interface)
- 預設實作、預設方法(Default methods)
- 使用Stream API:[閱讀API前必須知道的四大介面](#閱讀api前必須知道的四大介面)、[誰可以使用Stream?](#誰可以使用stream)、[Stream怎麼用?](stream怎麼用-java.util.stream.stream)


### 處理null的好幫手 Optional




* * *

## Lambda
### 基本的Lambda演算
```java
// not 可以用Lambda表示為
false -> true
true  -> false
// and 可以用Lambda表示為
value false -> false
value true   -> value
false  value -> false
true   value -> value
// or 可以用Lambda表示為
value false -> value
value true   -> true
false  value -> value
true   value -> true
// If 可以用Lambda表示為
 condition -> trueValue -> falseValue -> 
(condition and trueValue) or (not condition and falseValue)
// 若condition為true
(true      and trueValue) or (not condition and falseValue)
(trueValue) or (not condition and falseValue)
(trueValue) or (false         and falseValue)
(trueValue) or (false                       )
(trueValue)
// 若condition為false
(false and trueValue) or (not condition and falseValue)
(false              ) or (not condition and falseValue)
                         (not condition and falseValue)
                         (not false     and falseValue)
                         (true          and falseValue)
                         (                  falseValue)
 
```

### 簡化匿名類別的實作
-  使用匿名類別
```java
Collections.sort(students, new Comparator<Student>() {
	@Override
	public int compare(Student o1, Student o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
});
```
- 使用Lambda
```java
Collections.sort(students, Comparator.comparing(student -> student.getAge()));
```




### 何謂管線操作風格?
- 非管線式
```java
CustomizedHelperLikeType.map(
CustomizedHelperLikeType.filter(
CustomizedHelperLikeType.list(1, 2, 3), condition), mapper);
```
- 管線式
```java
CustomizedStreamLikeTypeImpl
.of(1, 2, 3)
.filter(condition)
.map(mapper)
.get()
```
### 管線化的好處
- 商業邏輯單元化: 測試、重組
- 流程與邏輯切割分明: 可讀性、維護

### 何謂抽象方法介面(Functional Interface)?
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
- java.util.function.Function
  - input 轉變成 output
- java.util.function.Predicate
  - input 轉變成 boolean
- java.util.function.Consumer
  - 有input, 沒有output
- java.util.function.Supplier
  - 沒有input, 有output

* * *
## Stream 與 Lambda
