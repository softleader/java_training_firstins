package lambda.exercise.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import static java.util.stream.Collectors.*;
import java.util.stream.Collectors;

public class CollectService {

  Supplier<Integer[]> initialData = () -> new Integer[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
      0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};


  public void collectToList() {
    List<Integer> collect = Arrays.stream(initialData.get())
        .collect(toList());

  }

  public void collectToSet() {
    Set<Integer> collect = Arrays.stream(initialData.get())
        .collect(toSet());
  }

  public void collectToMap() {
    Map<String, Integer> collect = Arrays.stream(initialData.get())
        .collect(toMap(i -> "key:" + i, i -> i));
  }

  // 偶數 奇數 分組
  public void collectGroupingBy() {

    Map<Boolean, List<Integer>> mapGroupingByIsOdd = Arrays.stream(initialData.get())
        .collect(Collectors.groupingBy(integer -> integer % 2 == 1));

    Map<Integer, List<Integer>> mapGroupingByMod = Arrays.stream(initialData.get())
        .collect(Collectors.groupingBy(integer -> integer % 2));
  }
}
