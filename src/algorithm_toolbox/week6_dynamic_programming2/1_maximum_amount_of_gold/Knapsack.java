import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int [][] dp = new int[W + 1][w.length + 1];

        for(int i=0; i <= W; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i <= w.length; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i <= W; i++){
            for(int j=0; j < w.length; j++){
                
                if(i-w[j] >= 0){
                    dp[i][j+1] = Math.max(dp[i-w[j]][j] + w[j], dp[i][j]); // TODO we either take the element or not, second index i?
                }
                else{
                    dp[i][j+1] = dp[i][j];
                }

//                System.out.println("dp["+i+"]["+j+"] = " + dp[i][j]);
            }
        }

//        int result = 0;
//        for (int i = 0; i < w.length; i++) {
//          if (result + w[i] <= W) {
//            result += w[i];
//          }
//        }
        return dp[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

