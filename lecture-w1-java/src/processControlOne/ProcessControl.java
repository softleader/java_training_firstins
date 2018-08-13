package processControlOne;

import com.google.inject.internal.util.Maps;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class ProcessControl {

  enum SwitchType {
    A,
    B,
    C,
  }

  public static void main(String[] args) {
//		method1();
//		method2((int) (Math.random()*10), (int) (Math.random()*10));
//		method3();
//		method4();
//		method5();
//		method6();
//    method7();
//    method8();

  }

  // Entry & switch
  private static void method8() {
    Entry[] entries = {
        new SimpleEntry(SwitchType.A, "Tom"),
        new SimpleEntry(SwitchType.B, "Jane"),
        new SimpleEntry(SwitchType.C, "Meta"),
        new SimpleEntry(SwitchType.A, "Joy"),
        new SimpleEntry(SwitchType.B, "Matt"),
        new SimpleEntry(SwitchType.C, "Rhys"),
        new SimpleEntry(SwitchType.A, "David"),
        new SimpleEntry(SwitchType.B, "Tony"),
        new SimpleEntry(SwitchType.C, "Sam")
    };

    for (Entry<SwitchType, String> entry : entries) {
      SwitchType k = entry.getKey();
      String v = entry.getValue();
      switchPrinter(k, v);
    }
  }

  //
  private static void switchPrinter(SwitchType k, String v) {
    switch (k) {
      case A:
        System.out.printf("Team %s \t %s\n", k.name(), v);
        break;
      case B:
        System.out.printf("Team %s \t %s\n", k.name(), v);
        break;
      case C:
        System.out.printf("Team %s \t %s\n", k.name(), v);
        break;
      default:
        System.out.printf("Team %s \t %s\n", k.name(), v);
        break;

    }
  }
  // Map & switch
  private static void method7() {
    LinkedHashMap<SwitchType, Object> m = Maps.newLinkedHashMap();
    m.put(SwitchType.A, "Tom");
    m.put(SwitchType.B, "Jane");
    m.put(SwitchType.C, "Meta");
    m.put(SwitchType.A, "Joy");
    m.put(SwitchType.B, "Matt");
    m.put(SwitchType.C, "Rhys");
    m.put(SwitchType.A, "David");
    m.put(SwitchType.B, "Tony");
    m.put(SwitchType.C, "Sam");

    // To figured out why there are only 3 results?
    m.forEach((k, v) -> {
      switchPrinter(k, (String) v);
    });
  }

  // 9X9
  private static void method6() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.printf("%d * %d = %d ", i + 1, j + 1, (i + 1) * (j + 1));
        // Make it pretty
        // System.out.printf("%2d * %2d = %2d \t", i+1, j+1, (i+1)*(j+1));
      }
      System.out.printf("\n");
    }
  }

  // 9X9
  private static void method5() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.printf("%d * %d = %d \n", i + 1, j + 1, (i + 1) * (j + 1));
      }
    }
  }

  // if...else if...else
  private static void method1() {
    int b = 10;
    int a = 11;
    if (a > b) {
      System.out.println(a + " > " + b);
    } else if (a < b) {
      System.out.println(a + " < " + b);
    } else {
      System.out.println(a + " = " + b);
    }
  }

  // extract local variable to parameter
  private static void method2(int a, int b) {
    if (a > b) {
      System.out.println(a + " > " + b);
    } else if (a < b) {
      System.out.println(a + " < " + b);
    } else {
      System.out.println(a + " = " + b);
    }
  }

  // while
  private static void method3() {
    int i = 0;
    while (i < 100) {
      System.out.printf("%3d: ", i + 1); // align at 3 digits
      method2((int) (Math.random() * 10), (int) (Math.random() * 10));
      i++;
    }
  }

  // do...while...
  private static void method4() {
    int i = 0;

    do {
      System.out.printf("%3d: ", i + 1); // align at 3 digits
      method2((int) (Math.random() * 10), (int) (Math.random() * 10));
      i++;
    } while (i < 100);
  }


}
