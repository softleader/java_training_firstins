package lambda.exercise;

import java.util.Objects;
import lambda.exercise.service.PersonService;

public class HumanResourceExecutor {


  public static void main(String[] args) {
    System.out.println(Objects.isNull(new PersonService().getByEmpNo(1)));
    System.out.println(new PersonService().getHasAnyParent().size());
  }

}
