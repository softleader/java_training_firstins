package Inheritance.setting.model;

import Inheritance.common.model.AbstractModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class AbstractSetting extends AbstractModel implements GenericSetting {

  protected String code;
  protected Integer seqNo;


}
