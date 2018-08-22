package lambda.exercise;

import lambda.exercise.service.FunctionalApi;

public class FunctionalApiExecutor {


  public static void main(String[] args) {
    FunctionalApi api = new FunctionalApi();
    api.getIntegerStringFunction();
    api.getIntegerStringFunctionLambda();
    api.aggregateWithReduce();
    api.aggregateWithOldSchool();
    api.aggregateWithReduceInOptional();
  }
}
