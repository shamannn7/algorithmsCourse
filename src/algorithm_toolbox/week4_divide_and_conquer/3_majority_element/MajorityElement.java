import java.util.*;
import java.io.*;

public class MajorityElement {

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

    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        Arrays.sort(a);
        int middleIndex = left +  (right - left)/2;

        System.out.println("middleIndex = " + middleIndex);

        int found = binarySearch(a,a[middleIndex], left, right);

        System.out.println("found = " + found);


        if(((a.length/2 + found) < a.length) && (a[found] == a[a.length/2 + found])){
            return a[found];
        }

        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

