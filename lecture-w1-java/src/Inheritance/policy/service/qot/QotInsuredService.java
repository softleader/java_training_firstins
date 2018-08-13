package Inheritance.policy.service.qot;

import Inheritance.policy.model.qot.QotInsured;
import Inheritance.policy.service.GenericInsuredService;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public interface QotInsuredService extends GenericInsuredService<QotInsured> {
  BigDecimal aggregatePremium(List<QotInsured> insureds);
  default Predicate<QotInsured> getPolicyTypeFilter() {
    return (insured) -> "QOT".equals(insured.getPolicyType());
  }

}
