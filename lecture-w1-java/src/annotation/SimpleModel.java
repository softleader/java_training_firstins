package annotation;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SimpleModel {

  @SimpleAnnotation(value = "localName", desc = "名稱")
  String localName = "";



}
