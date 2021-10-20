import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
//    private static int getFibonacciLastDigitNaive(int n) {
//        if (n <= 1)
//            return n;
//
//        int previous = 0;
//        int current  = 1;
//
//        for (int i = 0; i < n - 1; ++i) {
//            int tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//        }
//
//        return current % 10;
//    }

    private static long getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        long[] fibonacciArray = new long[n];
        fibonacciArray[0] = 1;
        fibonacciArray[1] = 1;

        for(int i=2; i< n; i++){
            fibonacciArray[i] = fibonacciArray[i-2]% 10 + fibonacciArray[i-1]% 10;
        }

//        for(int i=0; i< n; i++) {
//            System.out.println(fibonacciArray[i]);
//        }

        return fibonacciArray[n-1] % 10;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

