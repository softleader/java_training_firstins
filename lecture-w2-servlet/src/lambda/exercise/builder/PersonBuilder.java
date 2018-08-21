package lambda.exercise.builder;

import com.google.inject.internal.util.Lists;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lambda.exercise.enums.Gender;
import lambda.exercise.enums.Relation;
import lambda.exercise.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonBuilder {
  private String name;
  private Integer empNo;
  private Gender gender;
  private Relation relation = Relation.SELF;
  private BigDecimal wageRate = BigDecimal.valueOf(120);
  private BigDecimal workHour = BigDecimal.valueOf(8);
  private List<Person> parents = Lists.newArrayList();


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

  public PersonBuilder relation(Relation relation) {
    this.relation = relation;
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

  public PersonBuilder parent(Person... p) {
    getParents().addAll(Arrays.asList(p));
    return this;
  }

  public Person build() {
    Person person = new Person();
    person.setName(this.name);
    person.setGender(this.gender);
    person.setRelation(this.relation);
    person.setEmpNo(this.empNo);
    person.setWageRate(this.wageRate);
    person.setWorkHour(this.workHour);
    person.getParents().addAll(this.getParents());
    return person;
  }
}
