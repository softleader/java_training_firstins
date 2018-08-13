package Inheritance.policy.service.pos.impl;

import Inheritance.policy.model.pos.PosInsured;
import Inheritance.policy.service.AbstractInsuredService;
import Inheritance.policy.service.pos.PosInsuredService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PosInsuredServiceImpl extends AbstractInsuredService<PosInsured> implements PosInsuredService {


  public BigDecimal aggregatePremium(List<PosInsured> insureds) {
    List<PosInsured> qotInsureds = insureds.stream().filter(getPolicyTypeFilter()).collect(Collectors.toList());
    return super.aggregatePremium(qotInsureds);
  }
}
