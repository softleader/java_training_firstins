package Inheritance.policy.service.pos;

import Inheritance.policy.model.pos.PosInsured;
import Inheritance.policy.service.GenericInsuredService;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public interface PosInsuredService extends GenericInsuredService<PosInsured> {
  BigDecimal aggregatePremium(List<PosInsured> insureds);

  default Predicate<PosInsured> getPolicyTypeFilter() {
    return (insured) -> "POS".equals(insured.getPolicyType());
  }

}
