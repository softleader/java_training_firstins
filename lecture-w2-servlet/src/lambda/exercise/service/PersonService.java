package lambda.exercise.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lambda.exercise.builder.PersonBuilder;
import lambda.exercise.enums.Gender;
import lambda.exercise.enums.Relation;
import lambda.exercise.model.Person;

public class PersonService {


  /**
   * 最終結果可以自己用Optional包起來
   * 也可以呼叫現有的API
   * @param empNo
   * @return
   */
  public Optional<Person> getByEmpNo(int empNo) {
    // TODO
    // 1.取出全部
    // 2.過濾
    // 3.取一筆

   return null;
  }

  public Map<Gender, List<Person>> getAllAndGroupingByGender() {
    // TODO
    // 1.取出全部
    // 2.分組(性別)
    // 3.收集


    return null;
  }

  public Map<Gender, Map<String, List<Person>>> getAllAndGroupingByGenderAndName() {
    // TODO
    // 1.取出全部
    // 2.分組(性別)
    // 3.分組(姓名)
    // 4.收集

    return null;
  }

  /**
   *
   * 上面兩隻方法都用到 「依性別分組」的邏輯
   * 雖然過於簡單的邏輯不適合抽出, 不過請試著抽出這個共用邏輯, 並且觀察它的組成
   *
   * {@link Collectors#groupingBy {@link java.util.function.Function classifier}}
   *
   *
   */


  public List<Person> getByWorkHourOver(BigDecimal workHour) {
    // TODO
    // 1.取出全部
    // 2.過濾
    // 3.收集

    return null;
  }

  /**
   * 學習使用較複雜的{@link java.util.function.Predicate#or(Predicate)}
   * @return
   */
  public List<Person> getHasAnyParent() {
    // TODO
    // 1.取出全部
    // 2.過濾
    // 3.收集
    return null;
  }

  /**
   * 學習使用{@link Stream#flatMap(Function)} 來「攤平」資料
   * @return
   */
  public List<Person> getAllParent() {
    // TODO
    // 1.取出全部
    // 2.過濾
    // 3.收集
    return null;
  }


public List<Person> getAll() {

  Person p1 = new PersonBuilder().name("Matt").empNo(1).gender(Gender.MALE)
      .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
      .parent(
          new PersonBuilder().name("Matt's Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("Matt's Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  Person p2 = new PersonBuilder().name("David").empNo(2).gender(Gender.MALE)
      .wageRate(BigDecimal.valueOf(999)).workHour(BigDecimal.valueOf(9))
      .parent(
          new PersonBuilder().name("David's Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("David's Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  Person p3 = new PersonBuilder().name("Rhys").empNo(3).gender(Gender.MALE)
      .wageRate(BigDecimal.valueOf(998)).workHour(BigDecimal.valueOf(10))
      .parent(
          new PersonBuilder().name("Rhys' Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("Rhys' Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  Person p4 = new PersonBuilder().name("Thomas").empNo(4).gender(Gender.MALE)
      .wageRate(BigDecimal.valueOf(997)).workHour(BigDecimal.valueOf(11))
      .parent(
          new PersonBuilder().name("Thomas's Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("Thomas's Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  Person p5 = new PersonBuilder().name("Meta").empNo(5).gender(Gender.FEMALE)
      .wageRate(BigDecimal.valueOf(996)).workHour(BigDecimal.valueOf(8))
      .parent(
          new PersonBuilder().name("Meta's Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("Meta's Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  Person p6 = new PersonBuilder().name("Sophie").empNo(6).gender(Gender.FEMALE)
      .wageRate(BigDecimal.valueOf(995)).workHour(BigDecimal.valueOf(9))
      .parent(
          new PersonBuilder().name("Sophie's Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("Sophie's Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  Person p7 = new PersonBuilder().name("Sunny").empNo(7).gender(Gender.FEMALE)
      .wageRate(BigDecimal.valueOf(994)).workHour(BigDecimal.valueOf(10))
      .parent(
          new PersonBuilder().name("Sunny's Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("Sunny's Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  Person p8 = new PersonBuilder().name("Cathy").empNo(8).gender(Gender.FEMALE)
      .wageRate(BigDecimal.valueOf(993)).workHour(BigDecimal.valueOf(11))
      .parent(
          new PersonBuilder().name("Cathy's Father").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.FATHER).build(),
          new PersonBuilder().name("Cathy's Mother").empNo(1).gender(Gender.MALE)
              .wageRate(BigDecimal.valueOf(1000)).workHour(BigDecimal.valueOf(8))
              .relation(Relation.MOTHER).build()
      )
      .build();
  return Stream.of(p1, p2, p3, p4, p5, p6, p7, p8).collect(Collectors.toList());

}
}
