package lambda.exercise;

import lambda.exercise.collector.CollectServiceAdvance;

public class CollectServiceExecutor {

  public static void main(String[] args) {
    CollectServiceAdvance collectServiceAdvance = new CollectServiceAdvance();
    collectServiceAdvance.aggregateWithCollect();
    collectServiceAdvance.aggregateWithCollect2();
  }


}
