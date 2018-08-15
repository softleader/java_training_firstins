package inheritance.policy.model.qot;

import inheritance.policy.model.AbstractInsured;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QotInsured extends AbstractInsured {

  public QotInsured() {
    this("NONE");
  }
  public QotInsured(String policyType) {
    super();
    setPolicyType(policyType);
  }

private String quotationNo;
private int version;

}
