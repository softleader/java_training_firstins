package inheritance;

import inheritance.policy.model.AbstractInsured;
import inheritance.policy.model.qot.QotInsured;
import inheritance.policy.service.GenericInsuredService;
import inheritance.policy.service.qot.impl.QotInsuredServiceImpl;
import com.google.inject.internal.util.Lists;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Practice1 {


  private static GenericInsuredService qotInsuredService = new QotInsuredServiceImpl();

  public static void main(String[] args) {

    List<AbstractInsured> insureds = getInsureds();
    BigDecimal totalPremium = qotInsuredService.aggregatePremium(insureds);
    System.out.printf("保費加總:\t%s\n", totalPremium);




  }

  private static List<AbstractInsured> getInsureds() {
    QotInsured p1 = new QotInsured("QOT");
    p1.setQuotationNo("00QFIR00001");
    p1.setVersion(1);
    p1.setEmpNo("1");
    p1.setIdno("A123456789");
    p1.setLocalName("Thomas");
    p1.setPremium(BigDecimal.valueOf(1000));
    p1.setModifiedBy("admin");
    p1.setModifiedTime(LocalDateTime.now());
    p1.setCreatedBy("admin");
    p1.setCreatedTime(LocalDateTime.now());

    QotInsured p2 = new QotInsured("QOT");
    p2.setQuotationNo("00QFIR00001");
    p2.setVersion(1);
    p2.setEmpNo("2");
    p2.setIdno("A123456788");
    p2.setLocalName("Tim");
    p2.setPremium(BigDecimal.valueOf(500));
    p2.setModifiedBy("admin");
    p2.setModifiedTime(LocalDateTime.now());
    p2.setCreatedBy("admin");
    p2.setCreatedTime(LocalDateTime.now());

    QotInsured p3 = new QotInsured("POS"); // Miss
//    QotInsured p3 = new QotInsured("QOT");
    p3.setQuotationNo("00QFIR00002"); // Diff
    p3.setVersion(1);
    p3.setEmpNo("3");
    p3.setIdno("A123456787");
    p3.setLocalName("Tony");
    p3.setPremium(BigDecimal.valueOf(500));
    p3.setModifiedBy("admin");
    p3.setModifiedTime(LocalDateTime.now());
    p3.setCreatedBy("admin");
    p3.setCreatedTime(LocalDateTime.now());

    return Lists.newArrayList(p1, p2, p3);
  }


}
