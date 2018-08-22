package lambda.exercise.collector;

import com.google.inject.internal.util.Lists;
import com.google.inject.internal.util.Sets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectServiceAdvance {

  /**
   * collect(自行實作Collector的寫法)
   */
  public void aggregateWithCollect() {
    Object result = Stream.of(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
        0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(new Collector() {
      @Override
      public Supplier<List> supplier() {
        return () -> Lists.newArrayList();
      }

      @Override
      public BiConsumer<List, Integer> accumulator() {
        return (collectedDataWithFold, currentData) -> {
          if (currentData % 2 == 1 && currentData > 0) {
            collectedDataWithFold.add(currentData);
          }
        };
      }

      @Override
      public BinaryOperator<ArrayList> combiner() {
        return (collectedDataWithFold, anotherCollectedDataWithFold) -> {
          collectedDataWithFold.addAll(anotherCollectedDataWithFold);
          return collectedDataWithFold;
        };
      }

      @Override
      public Function<ArrayList, Integer> finisher() {
        return finalCollectedDataWithFold -> finalCollectedDataWithFold.stream()
            .mapToInt(currentData -> (int) currentData).sum();
      }

      @Override
      public Set<Characteristics> characteristics() {
        return Sets.newHashSet();
      }
    });

    System.out.println(result);
  }


  /**
   * collect(三個參數的寫法)
   */
  public void aggregateWithCollect2() {
    // 先組成Map
    Map<String, Integer> dataMap = Stream.of(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
        0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        .collect(Collectors.toMap(i -> "key:" + i, i -> i));
    // 拆成entrySet 處理一些邏輯
    // 再組回Map
    LinkedHashMap<String, Integer> dataMap2 = dataMap.entrySet().stream()
        .collect(LinkedHashMap::new, this::getPositiveOdd, LinkedHashMap::putAll);


  }

  private void getPositiveOdd(Map map, Entry<String, Integer> entry) {
    if (entry.getValue() % 2 == 1 && entry.getValue() > 0) {
      map.put(entry.getKey(), entry.getValue());
    }
  }


}
