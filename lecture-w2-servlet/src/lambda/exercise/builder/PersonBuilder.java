package lambda.exercise.builder;

import java.math.BigDecimal;
import lambda.exercise.enums.Gender;
import lambda.exercise.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonBuilder {
  private String name;
  private Integer empNo;
  private Gender gender;
  private BigDecimal wageRate;
  private BigDecimal workHour;

  public PersonBuilder name(String name) {
    this.name = name;
    return this;
  }

  public PersonBuilder empNo(Integer empNo) {
    this.empNo = empNo;
    return this;
  }

  public PersonBuilder gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public PersonBuilder wageRate(BigDecimal wageRate) {
    this.wageRate = wageRate;
    return this;
  }

  public PersonBuilder workHour(BigDecimal workHour) {
    this.workHour = workHour;
    return this;
  }


  public Person build() {
    Person person = new Person();
    person.setName(this.name);
    person.setGender(this.gender);
    person.setEmpNo(this.empNo);
    person.setWageRate(this.wageRate);
    person.setWorkHour(this.workHour);
    return person;
  }
}
