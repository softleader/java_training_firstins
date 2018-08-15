package inheritance;

import inheritance.policy.model.AbstractInsured;
import inheritance.policy.service.GenericInsuredService;
import com.google.inject.internal.util.Lists;
import java.math.BigDecimal;
import java.util.List;

public class Practice2 {

  // TODO after you complete PosInsuredService, PosInsuredServiceImpl.
  private static GenericInsuredService qotInsuredService = null;


  public static void main(String[] args) {
    List<AbstractInsured> insureds = getInsureds();
    // TODO call service to calculate premium.
    BigDecimal totalPremium = BigDecimal.ZERO;


    System.out.printf("保費加總:\t%s\n", totalPremium);

  }


  private static List<AbstractInsured> getInsureds() {
    // TODO new Object
    return Lists.newArrayList();
  }

}
