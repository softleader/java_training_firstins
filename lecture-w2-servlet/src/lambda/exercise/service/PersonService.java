package lambda.exercise.service;

import com.google.inject.internal.util.Lists;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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


  public List<Person> getByWorkHourOver(int workHour) {
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

  /**
   * 情境：父親節寄賀卡, 需要找出所有人的父親們.
   * 又出現重複的邏輯了！ 只要再加上一點新判斷就能組成新的商業邏輯
   * 雖然可以直接呼叫{@link #getAllParent()} 之後再過濾, 不過代價是相依性增加(若getAllParent變動, 則所有相依的邏輯也跟著變動)
   * 比較好的做法是把邏輯包裝在每個方法中, 抽出的邏輯必須是真的可以被共用的.
   * @return
   */
  public List<Person> getAllFather() {
    // TODO
    // 1.取出全部
    // 2.過濾
    // 3.收集
    return null;
  }

  public List<Person> getAllMother() {
    // TODO
    // 1.取出全部
    // 2.過濾
    // 3.收集
    return null;
  }

  /**
   * 找出夠「富裕」的母親
   * 「富裕」的定義
   *  1. 個人的所得
   * @return
   */
  public List<Person> getAllWealthyMother(double income) {
    // TODO
    // 1.取出全部
    // 2.過濾
    // 3.收集

    return null;
  }

  /**
   *
   * 找出夠「富裕」的母親
   * 「富裕」的定義
   *  1. 個人的所得
   *  2. 整戶的所得
   *  3. 先整戶所得, 其餘者再個人所得
   *  依據整戶總所得超過門檻A的家庭分成兩組
   *  針對戶所得較高的群組 取出
   *  針對戶所得較低的群組 再次過濾個人所得高於某門檻B
   *
   *
   *
   * @return
   */
  public List<Person> getAllWealthyMother() {
    // TODO
    // 1.取出全部
    // 2.過濾(使用 or方法)
    // 3.收集

    return null;
  }


  public List<Person> getAll() {

   Person matt = new Person("Matt", 1, Gender.MALE, Relation.SELF, 1000, 8, Lists.newArrayList(
       new Person("Matt's Dad", 0, Gender.MALE, Relation.FATHER, 1000, 8, Lists.newArrayList(), 8000),
       new Person("Matt's Mom", 0, Gender.FEMALE, Relation.MOTHER, 1000, 8, Lists.newArrayList(), 8000)
   ), 8000);
   Person david = new Person("David", 1, Gender.MALE, Relation.SELF, 1000, 8, Lists.newArrayList(
       new Person("David's Dad", 0, Gender.MALE, Relation.FATHER, 1000, 8, Lists.newArrayList(), 8000),
       new Person("David's Mom", 0, Gender.FEMALE, Relation.MOTHER, 1000, 8, Lists.newArrayList(), 8000)
   ), 8000);
    Person rhys = new Person("Rhys", 1, Gender.MALE, Relation.SELF, 1000, 8, Lists.newArrayList(
       new Person("Rhys's Dad", 0, Gender.MALE, Relation.FATHER, 1000, 8, Lists.newArrayList(), 8000),
       new Person("Rhys's Mom", 0, Gender.FEMALE, Relation.MOTHER, 1000, 8, Lists.newArrayList(), 8000)
   ), 8000);
    Person thomas = new Person("Thomas", 1, Gender.MALE, Relation.SELF, 1000, 8, Lists.newArrayList(
       new Person("Thomas's Dad", 0, Gender.MALE, Relation.FATHER, 1000, 8, Lists.newArrayList(), 8000),
       new Person("Thomas's Mom", 0, Gender.FEMALE, Relation.MOTHER, 1000, 8, Lists.newArrayList(), 8000)
   ), 8000);



   return Lists.newArrayList(matt, david, rhys, thomas);


}
}
