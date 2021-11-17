import java.util.*;

public class GCD {
//  private static int gcd_naive(int a, int b) {
//    int current_gcd = 1;
//    for(int d = 2; d <= a && d <= b; ++d) {
//      if (a % d == 0 && b % d == 0) {
//        if (d > current_gcd) {
//          current_gcd = d;
//        }
//      }
//    }
//
//    return current_gcd;
//  }

//  private static long gcd_naive(int a, int b) {
//    long currentGcd = 1;
//
//    long left = a, right = b;
//
//    do{
//      currentGcd = (left % right);
//      left = right;
//      right = currentGcd;
//    }while(currentGcd > 0);
////    for(int d = 2; d <= a && d <= b; ++d) {
////      if (a % d == 0 && b % d == 0) {
////        if (d > currentGcd) {
////          currentGcd = d;
////        }
////      }
////    }
//    if(currentGcd == 0){
//      currentGcd = 1;
//    }
//
//    return currentGcd;
//  }

  private static long gcd_naive(int a, int b) {
    if(b == 0){
      return a;
    }

    int remainder = a % b;

    return gcd_naive(b, remainder);
  }


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
