package Inheritance.policy.service.qot.impl;

import Inheritance.policy.model.qot.QotInsured;
import Inheritance.policy.service.AbstractInsuredService;
import Inheritance.policy.service.qot.QotInsuredService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class QotInsuredServiceImpl extends AbstractInsuredService<QotInsured> implements QotInsuredService {

  public BigDecimal aggregatePremium(List<QotInsured> insureds) {
    List<QotInsured> qotInsureds = insureds.stream().filter(getPolicyTypeFilter()).collect(Collectors.toList());
   return super.aggregatePremium(qotInsureds);
  }

}
