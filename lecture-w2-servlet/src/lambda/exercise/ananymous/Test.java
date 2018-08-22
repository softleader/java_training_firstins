package lambda.exercise.ananymous;

import java.util.function.Function;

public class Test {

  public static void main(String[] args) {
    Function f1 = new Function() {
      @Override
      public Object apply(Object o) {
        return o.toString();
      }
    };

    // Lambda
    Function f2 = o -> o.toString();

    Function f3 = o -> {
      return o.toString();
    };
  }

}
