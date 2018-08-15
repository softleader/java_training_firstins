package inheritance.policy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public interface GenericInsuredService<T> {

  BigDecimal aggregatePremium(List<T> insureds);
  Predicate<T> getPolicyTypeFilter();

}
