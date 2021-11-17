import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
        int len = exp.length()/2;
        int lenOfNums = exp.length()/2 + 1;

        int[] nums = new int[lenOfNums];
        char[] ops = new char[len];
        int numsCount =0, opsCount=0;
        for (int i=0; i < exp.length(); i++){
            if(i % 2 == 0){
                nums[numsCount] = exp.charAt(i) - '0';
                numsCount++;
            }
            else{
                ops[opsCount] = exp.charAt(i);
                opsCount++;
            }
        }

        long[][] minDp = new long[lenOfNums][lenOfNums];
        long[][] maxDp = new long[lenOfNums][lenOfNums];

        for (int i = 0; i < lenOfNums; i++) {
                minDp[i][i] = nums[i];
                maxDp[i][i] = nums[i];
        }


//        for (int j = 1; j < lenOfNums; j++) {
//            for (int i = 0; i < j; i++) {
        for (int s = 1; s < lenOfNums; s++) {
//            System.out.println("subproblem = " + s);
            for (int i = 0; i < lenOfNums - s; i++) {
                    int j = i + s;
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
                    long curMax = Long.MIN_VALUE;
                    long curMin = Long.MAX_VALUE;
                     for (int k = i; k < j; k++) {
//                        System.out.println("k = " + k);
//                        System.out.println("ops[k] = " + ops[k]);
                       long max = eval(maxDp[i][k], maxDp[k+1][j], ops[k]);
                       long maxMin = eval(maxDp[i][k], minDp[k+1][j], ops[k]);
                       long minMax = eval(minDp[i][k], maxDp[k+1][j], ops[k]);
                       long minMin = eval(minDp[i][k], minDp[k+1][j], ops[k]);

//                         System.out.println("max = " + max);
//                         System.out.println("maxMin = " + maxMin);
//                         System.out.println("minMax = " + minMax);
//                         System.out.println("minMin = " + minMin);

                       curMax = Math.max(curMax, Math.max(max, Math.max(maxMin, Math.max(minMax, minMin))));
                       curMin = Math.min(curMin, Math.min(max, Math.min(maxMin, Math.min(minMax, minMin))));
                }
                maxDp[i][j] = curMax;
                minDp[i][j] = curMin;
            }
        }

/*
        for (int j = 0; j < lenOfNums; j++) {
            for (int i = 0; i <= j; i++) {
                System.out.println("maxDp["+i+"]["+j+"] = " + maxDp[i][j]);
            }}

        for (int j = 0; j < lenOfNums; j++) {
            for (int i = 0; i <= j; i++) {
                System.out.println("minDp["+i+"]["+j+"] = " + minDp[i][j]);
            }}
*/

        return maxDp[0][lenOfNums - 1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

