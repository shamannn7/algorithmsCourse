import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
        int len = exp.length()/2;
        int lenOfNums = exp.length()/2 + 1;

        System.out.println("len = " + len);

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

        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[i] = " + nums[i]);
        }
        for (int i = 0; i < ops.length; i++) {
            System.out.println("ops[i] = " + ops[i]);
        }

        long[][] minDp = new long[lenOfNums][lenOfNums];
        long[][] maxDp = new long[lenOfNums][lenOfNums];

        for (int i = 0; i < lenOfNums; i++) {
                minDp[i][i] = nums[i];
                maxDp[i][i] = nums[i];
        }

        for (int j = 1; j < lenOfNums; j++) {
            for (int i = 0; i < j; i++) {
               long max = eval(maxDp[i][j-1], maxDp[i+1][j], ops[i]);
               long maxMin = eval(maxDp[i][j-1], minDp[i+1][j], ops[i]);
               long minMax = eval(minDp[i][j-1], maxDp[i+1][j], ops[i]);
               long minMin = eval(minDp[i][j-1], minDp[i+1][j], ops[i]);

                maxDp[i][j] = Math.max(max, Math.max(maxMin, Math.max(minMax, minMin)));
                minDp[i][j] = Math.min(max, Math.min(maxMin, Math.min(minMax, minMin)));
            }
        }


        for (int j = 1; j < lenOfNums; j++) {
            for (int i = 0; i < j; i++) {
                System.out.println("maxDp[i][j] = " + maxDp[i][j]);
                System.out.println("minDp[i][j] = " + minDp[i][j]);
            }}


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

