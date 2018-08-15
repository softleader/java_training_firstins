package inheritance.policy.service.pos;

import inheritance.policy.model.pos.PosInsured;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public interface PosInsuredService
//    extends GenericInsuredService<PosInsured>
 {
  BigDecimal aggregatePremium(List<PosInsured> insureds);

  default Predicate<PosInsured> getPolicyTypeFilter() {
    return (insured) -> "POS".equals(insured.getPolicyType());
  }

}
