import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

//    private static long getFibonacciSumNaive(int n) {
//        if (n <= 1)
//            return n;
//
//        long[] fibonacciArray = new long[n];
//        fibonacciArray[0] = 1;
//        fibonacciArray[1] = 2;
//
//        for(int i=2; i< n; i++){
//            fibonacciArray[i] = fibonacciArray[i-2]% 10 + fibonacciArray[i-1]% 10;
//        }
//
////        for(int i=0; i< n; i++) {
////            System.out.println(fibonacciArray[i]);
////        }
//
//        return fibonacciArray[n-1] % 10;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

