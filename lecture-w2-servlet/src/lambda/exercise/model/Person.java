package lambda.exercise.model;


import com.google.inject.internal.util.Lists;
import java.math.BigDecimal;
import java.util.List;
import lambda.exercise.enums.Gender;
import lambda.exercise.enums.Relation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private String name;
  private int empNo;
  private Gender gender;
  private Relation relation = Relation.SELF;
  private double wageRate = 120;
  private int workHour = 8;
  private List<Person> parents = Lists.newArrayList();
  private double salary;




}
