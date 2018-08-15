package inheritance.policy.service;

import inheritance.policy.model.AbstractInsured;
import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractInsuredService<T extends AbstractInsured> implements GenericInsuredService<T>{

  public BigDecimal aggregatePremium(List<T> insureds) {

    return insureds.stream().map(T::getPremium).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

}
