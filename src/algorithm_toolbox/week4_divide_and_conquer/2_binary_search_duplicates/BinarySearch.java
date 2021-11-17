import java.io.*;
import java.util.*;

public class BinarySearch {

        static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length;
        //write your code here. TODO some checkups for input validity?

        return binarySearch(a, x, left, right);
    }

    static int binarySearch(int[] a, int x, int left, int right) {
//        if(right < left){
//            return left-1;
//        }
        int found = -1;

        //write your code here
        while(left <= right){
//            int mid = left + Math.floorDiv(right - left,2);
//            int mid = left + (int)Math.floor((right - left)/2);
//            int mid = (int)Math.floor(left + (right - left)/2);
            int mid = left + (right - left)/2;

            if(mid >= a.length){
                return -1;  // TODO found or -1?
            }

//            System.out.println("left = "+ left);
//            System.out.println("right = "+ right);
//            System.out.println("mid = "+ mid);
//            System.out.println("a[mid]) = "+ a[mid]);
//            System.out.println("a.length = "+ a.length);

            if(a[mid] == x){
                found = mid;
                right = mid -1;
            }
            else if (x > a[mid]){
                left = mid +1;
            }
            else{ // a[mid] < x
                right = mid -1;
            }
        }

        return found;
    }

//    static int linearSearch(int[] a, int x) {
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == x) return i;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
