import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {

    for (long l = a; l <= (long) a * b; l+=a){
//      System.out.println("l = " + l);
      if (l % b == 0)
        return l;
    }

    return (long) a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
