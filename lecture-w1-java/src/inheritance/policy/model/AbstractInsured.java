package inheritance.policy.model;

import inheritance.common.model.AbstractModel;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractInsured extends AbstractModel {

  protected String policyType;
  protected String idno;
  protected String empNo;
  protected BigDecimal premium;

}
