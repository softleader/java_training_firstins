package lambda.exercise.model;


import java.math.BigDecimal;
import lambda.exercise.enums.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
  private String name;
  private Integer empNo;
  private Gender gender;
  private BigDecimal wageRate;
  private BigDecimal workHour;
  private BigDecimal salary;
}
