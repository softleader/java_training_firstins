package processcontrol.two;

import com.google.inject.internal.util.Maps;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.Setter;


public class ProcessControl {

  enum Gender {
    FEMALE,
    MALE,
  }

  static
  class Person {

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getEmpNo() {
      return empNo;
    }

    public void setEmpNo(Integer empNo) {
      this.empNo = empNo;
    }

    public Gender getGender() {
      return gender;
    }

    public void setGender(Gender gender) {
      this.gender = gender;
    }

    public BigDecimal getWageRate() {
      return wageRate;
    }

    public void setWageRate(BigDecimal wageRate) {
      this.wageRate = wageRate;
    }

    public BigDecimal getWorkHour() {
      return workHour;
    }

    public void setWorkHour(BigDecimal workHour) {
      this.workHour = workHour;
    }

    public BigDecimal getSalary() {
      return salary;
    }

    public void setSalary(BigDecimal salary) {
      this.salary = salary;
    }

    private String name;
    private Integer empNo;
    private Gender gender;
    private BigDecimal wageRate;
    private BigDecimal workHour;
    private BigDecimal salary;

    @Override
    public String toString() {
      return String.format("Name:%s\tEmpNo:%03d\tGender:%s\t", this.getName(), this.getEmpNo(),
          this.getGender());
    }
  }

  static
  class PersonBuilder {

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getEmpNo() {
      return empNo;
    }

    public void setEmpNo(Integer empNo) {
      this.empNo = empNo;
    }

    public Gender getGender() {
      return gender;
    }

    public void setGender(Gender gender) {
      this.gender = gender;
    }

    public BigDecimal getWageRate() {
      return wageRate;
    }

    public void setWageRate(BigDecimal wageRate) {
      this.wageRate = wageRate;
    }

    public BigDecimal getWorkHour() {
      return workHour;
    }

    public void setWorkHour(BigDecimal workHour) {
      this.workHour = workHour;
    }


    private String name;
    private Integer empNo;
    private Gender gender;
    private BigDecimal wageRate;
    private BigDecimal workHour;

    private PersonBuilder name(String name) {
      this.name = name;
      return this;
    }

    private PersonBuilder empNo(Integer empNo) {
      this.empNo = empNo;
      return this;
    }

    private PersonBuilder gender(Gender gender) {
      this.gender = gender;
      return this;
    }

    private PersonBuilder wageRate(BigDecimal wageRate) {
      this.wageRate = wageRate;
      return this;
    }

    private PersonBuilder workHour(BigDecimal workHour) {
      this.workHour = workHour;
      return this;
    }


    private Person build() {
      Person person = new Person();
      person.setName(this.name);
      person.setGender(this.gender);
      person.setEmpNo(this.empNo);
      person.setWageRate(this.wageRate);
      person.setWorkHour(this.workHour);
      return person;
    }

  }


  public static void main(String[] args) {
    method1();
//    method2();
//    method3();
//    method4();

  }

  // forEach
  private static void method1() {
    Map<String, List<Person>> empls =
//        Maps.newLinkedHashMap(); // TODO group by Name
        getEmpls().stream().collect(Collectors.groupingBy(Person::getName));
    // TODO sorted by empNo
    empls = empls.entrySet().stream()
//        .sorted(Comparator.comparing((entry) -> entry.getValue().stream().map(Person::getEmpNo).min(Comparator.reverseOrder()).get()))
        .collect(LinkedHashMap::new, (m, entry) -> m.put(entry.getKey(), entry.getValue()), Map::putAll)
;

    // Map
    empls.forEach((name, emps) -> {
      System.out.printf("\n\n%s:\n", name);
      // Object
      emps.forEach(emp -> {
        System.out.printf("(%03d)\t", emp.getEmpNo());
      });
    });


  }

  // Grouping by gender
  private static void method2() {
    Map<Gender, List<Person>> empls = getEmpls().stream()
        .collect(Collectors.groupingBy(Person::getGender, Collectors.toList()));

    empls.forEach((gender, emps) -> {
      System.out.printf("\n\nMember in gender %s:\n", gender.name());
      // Object
      emps.forEach(emp -> {
        System.out.printf("%s(%03d)\t", emp.getName(), emp.getEmpNo());
      });
    });
  }

  // Grouping by work hour.
  private static void method3() {

    Map<BigDecimal, List<Person>> empls = getEmpls().stream()
        .collect(Collectors.groupingBy(Person::getWorkHour, Collectors.mapping(p -> {
          p.setSalary(p.getWorkHour().multiply(p.getWageRate()));
          return p;
        }, Collectors.toList())));
    empls.forEach((workHour, emps) -> {
      System.out.printf("\n\nWork hours %s:\n", workHour);
      // Object
      emps.forEach(emp -> {
        System.out.printf("%s(%03d)\t(%s)\t", emp.getName(), emp.getEmpNo(),
            emp.getSalary().setScale(2).doubleValue());
      });
    });
  }

  // filter
  private static void method4() {
    List<Person> tiredEmpls = getEmpls().stream()
        .filter(p -> p.getWorkHour().compareTo(BigDecimal.valueOf(8)) > 0)
        .collect(Collectors.toList());

    tiredEmpls.forEach(emp -> {

      System.out.printf("%s\t(%03d)\t(%s)\t\n", emp.getName(), emp.getEmpNo(),
          emp.getWorkHour().toPlainString());


    });


  }

  private static List<Person> getEmpls() {
    Person p1 = new PersonBuilder().name("Matt").empNo(1).gender(Gender.MALE)
        .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
        .build();
    Person p2 = new PersonBuilder().name("David").empNo(2).gender(Gender.MALE)
        .wageRate(BigDecimal.valueOf(999)).workHour(BigDecimal.valueOf(9))
        .build();
    Person p3 = new PersonBuilder().name("Rhys").empNo(3).gender(Gender.MALE)
        .wageRate(BigDecimal.valueOf(998)).workHour(BigDecimal.valueOf(10))
        .build();
    Person p4 = new PersonBuilder().name("Thomas").empNo(4).gender(Gender.MALE)
        .wageRate(BigDecimal.valueOf(997)).workHour(BigDecimal.valueOf(11))
        .build();
    Person p5 = new PersonBuilder().name("Meta").empNo(5).gender(Gender.FEMALE)
        .wageRate(BigDecimal.valueOf(996)).workHour(BigDecimal.valueOf(8))
        .build();
    Person p6 = new PersonBuilder().name("Sophie").empNo(6).gender(Gender.FEMALE)
        .wageRate(BigDecimal.valueOf(995)).workHour(BigDecimal.valueOf(9))
        .build();
    Person p7 = new PersonBuilder().name("Sunny").empNo(7).gender(Gender.FEMALE)
        .wageRate(BigDecimal.valueOf(994)).workHour(BigDecimal.valueOf(10))
        .build();
    Person p8 = new PersonBuilder().name("Cathy").empNo(8).gender(Gender.FEMALE)
        .wageRate(BigDecimal.valueOf(993)).workHour(BigDecimal.valueOf(11))
        .build();
    return Stream.of(p1, p2, p3, p4, p5, p6, p7, p8).collect(Collectors.toList());
  }


}
