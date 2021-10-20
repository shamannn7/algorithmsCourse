import java.util.Scanner;

public class Fibonacci {
//  private static long calc_fib(int n) {
//    if (n <= 1)
//      return n;
//
//    return calc_fib(n - 1) + calc_fib(n - 2);
//  }

  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    int[] fibonacciArray = new int[n];
    fibonacciArray[0] = 1;
    fibonacciArray[1] = 1;

    for(int i=2; i< n; i++){
      fibonacciArray[i] = fibonacciArray[i-2] + fibonacciArray[i-1] ;
    }

//    for(int i=0; i< n + 1; i++) {
//      System.out.println(fibonacciArray[i]);
//    }

    return fibonacciArray[n-1];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
