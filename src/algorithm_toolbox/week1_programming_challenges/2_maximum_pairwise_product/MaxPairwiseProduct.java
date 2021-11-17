import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
//    static int getMaxPairwiseProduct(int[] numbers) {
//        int max_product = 0;
//        int n = numbers.length;
//
//        for (int first = 0; first < n; ++first) {
//            for (int second = first + 1; second < n; ++second) {
//                max_product = Math.max(max_product,
//                    numbers[first] * numbers[second]);
//            }
//        }
//
//        return max_product;
//    }

    static long getMaxPairwiseProduct(long[] numbers) {
        int n = numbers.length;

        int firstMaxIndex = -1, secondMaxIndex = -1;
        long firstMax = -1, secondMax = -1;
        for (int i = 0; i < n; i++) {
            if(numbers[i] > firstMax){
                firstMaxIndex = i;
                firstMax = numbers[firstMaxIndex];
            }
        }

        for (int i = 0; i < n; i++) {
            if((firstMaxIndex != i) && (numbers[i] > secondMax)){
                secondMaxIndex = i;
                secondMax = numbers[secondMaxIndex];
            }
        }

        return firstMax * secondMax;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
