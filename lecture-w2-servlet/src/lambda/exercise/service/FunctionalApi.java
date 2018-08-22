package lambda.exercise.service;

import com.google.inject.internal.util.Lists;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 閱讀API前必須知道的四大介面
 */
public class FunctionalApi {

  /**
   * 沒有Lambda 匿名類別的實作
   */
  public void getIntegerStringFunction() {
    Predicate<Integer> isPositive = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer > 0;
      }
    };
    Function<Integer, Integer> addOne = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer integer) {
        return integer + 1;
      }
    };
    Function<Integer, String> toString = new Function<Integer, String>() {

      @Override
      public String apply(Integer integer) {
        return "" + integer;
      }
    };
    Predicate<Integer> isOdd = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer % 2 == 1;
      }
    };
    Consumer<String> println = new Consumer<String>() {
      @Override
      public void accept(String o) {
        System.out.println(o);
      }
    };
    Supplier<Integer[]> initialData = new Supplier<Integer[]>() {
      @Override
      public Integer[] get() {
        return new Integer[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
            0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      }
    };

    // 只有Stream沒有Lambda的時候
    Arrays.stream(initialData.get())
        .filter(isPositive)
        .map(addOne)
        .filter(isOdd)
        .map(toString)
        .forEach(println);


  }

  /**
   * 有Lambda 匿名類別又剛好是Functional Interface 改用Lambda 實作
   */
  public void getIntegerStringFunctionLambda() {
    Predicate<Integer> isPositive = integer -> integer > 0;
    Function<Integer, Integer> addOne = integer -> integer + 1;
    Function<Integer, String> toString = integer -> "" + integer;
    Predicate<Integer> isOdd = integer -> integer % 2 == 1;
    Consumer<String> println = o -> System.out.println(o);
    // -10 ~ 10
    Supplier<Integer[]> initialData = () -> new Integer[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
        0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};    // 印出
    Arrays.stream(initialData.get())
        .filter(isPositive)
        .map(addOne)
        .filter(isOdd)
        .map(toString)
        .forEach(println);
  }

  /**
   * 使用 傳統寫法 作加總
   */
  public void aggregateWithOldSchool() {
    // 比較舊寫法
    Integer sumWithTraditional = 0;
    for (Integer integer : Lists.newArrayList(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
        0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)) {
      if (integer > 0) { // 等於filter
        integer++;
        if(integer % 2 == 1) {
          sumWithTraditional += integer;
        }
      }
    }

    System.out.println(sumWithTraditional);
  }

  /**
   * 使用 reduce  作加總
   */
  public void aggregateWithReduce() {
    Predicate<Integer> isPositive = integer -> integer > 0;
    Function<Integer, Integer> addOne = integer -> integer + 1;
    Function<Integer, String> toString = integer -> "" + integer;
    Predicate<Integer> isOdd = integer -> integer % 2 == 1;
    Consumer<String> println = o -> System.out.println(o);
    Supplier<Integer[]> initialData = () -> new Integer[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
        0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    // 加總By新寫法
    Integer sumWithReduce =
        Arrays.stream(initialData.get())
            .filter(isPositive)
            .map(addOne)
            .filter(isOdd)
            .reduce(0, (previousResult, currentData) -> previousResult + currentData);

    System.out.println(sumWithReduce);

  }

  /**
   * 使用 reduce 作加總 但是改用Optional
   */
  public void aggregateWithReduceInOptional() {
    Predicate<Integer> isPositive = integer -> integer > 0;
    Function<Integer, Integer> addOne = integer -> integer + 1;
    Function<Integer, String> mapper = integer -> "" + integer;
    Predicate<Integer> isOdd = integer -> integer % 2 == 1;
    Consumer<String> println = o -> System.out.println(o);
    // -10 ~ 10
    Supplier<Integer[]> initialData = () -> new Integer[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    Optional<Integer> optSum = Arrays.stream(initialData.get())
        .filter(isPositive)
        .map(addOne)
        .filter(isOdd)
        .reduce((previousResult, currentData) -> previousResult + currentData);

    System.out.println(optSum.orElse(0));
    // Optional 的方法
    optSum.get(); // 不建議
    optSum.isPresent();
    optSum.ifPresent(integer -> {
      // do something
    });
    optSum.orElseThrow(() -> new NoSuchElementException());
    optSum.orElseGet(() -> getFromDb());
//    optSum.orElse(getFromDb());

  }

  // 假裝去DB拿資料
  private Integer getFromDb() {
    throw new NullPointerException();
  }
}
