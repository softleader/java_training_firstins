package annotation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleModelService {


  public static void main(String[] args) {

    List<String> descs = Arrays.stream(SimpleModel.class.getDeclaredFields()).map(field -> {
      String value = field.getAnnotation(SimpleAnnotation.class).value();
      String desc = field.getAnnotation(SimpleAnnotation.class).desc();
      return value + desc;
    }).collect(Collectors.toList());

    System.out.printf("標籤取資料後再轉型(%s)", descs);


  }


}
