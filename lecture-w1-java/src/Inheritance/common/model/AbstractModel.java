package Inheritance.common.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class AbstractModel{

  protected String localName;

  protected LocalDateTime modifiedTime;
  protected LocalDateTime createdTime;
  protected String modifiedBy;
  protected String createdBy;



}
