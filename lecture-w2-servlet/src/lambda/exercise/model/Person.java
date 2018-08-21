package lambda.exercise.model;


import com.google.inject.internal.util.Lists;
import java.math.BigDecimal;
import java.util.List;
import lambda.exercise.enums.Gender;
import lambda.exercise.enums.Relation;
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
  private Relation relation = Relation.SELF;
  private BigDecimal wageRate = BigDecimal.valueOf(120);
  private BigDecimal workHour = BigDecimal.valueOf(8);
  private List<Person> parents = Lists.newArrayList();
  private BigDecimal salary;

}
