# Week 2 Introduction for Java8 Lambda and Java Servlet (2018/08/22)
## Lambda
### Lambda關心什麼？ 不關心什麼？
```
f(x) = x * 3
x -> x * 3
```
- 不關心函式介面的名稱
- 不關心目標型態 (因為有型別推斷)
- 不關心方法名稱 (Lambda運算式是匿名方法)
- 只關心方法的簽署(signature) (Lambda運算式的本體就是函式介面的方法實作)
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
### 函數式程式設計有什麼好處？
- 更抽象, 更共用
- 更專注於商業邏輯
- 更具可讀性(管線操作風格)
- 更有效率
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
- 中介操作(Intermediate operation/Aggregate operation)
- 最終操作(Terminal operation)

### Java8如何解決? 增加型態? 
- Java 8 沒有加入新的函式型態
- 取而代之的是而是使用抽象方法介面
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
### 閱讀API前必須知道的四大介面
- Supplier
- Consumer
- Function
- Predicate
