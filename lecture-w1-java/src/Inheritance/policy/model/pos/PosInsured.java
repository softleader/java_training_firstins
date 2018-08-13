package Inheritance.policy.model.pos;

import Inheritance.policy.model.AbstractInsured;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PosInsured extends AbstractInsured {


  public PosInsured() {
    this("NONE");
  }

  public PosInsured(String policyType) {
    super();
    setPolicyType(policyType);
  }

  private BigDecimal diffPremium;
  private String policyNo;
  private String endorsementNo;
  private String endstNo;





}
