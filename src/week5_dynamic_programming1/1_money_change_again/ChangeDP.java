import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here

        int[] dp = new int[m + 1];
        dp[0] = 0;

        for(int i=1; i < dp.length; i++){
            if(i >= 4){
                dp[i] = Math.min(dp[i-1] + 1, Math.min(dp[i-3] + 1, dp[i-4] + 1));
            }
            else if (i >= 3){
                dp[i] = Math.min(dp[i-1] + 1, dp[i-3] + 1);
            }
            else{
                dp[i] = dp[i-1] + 1;
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

