import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimalSequence(int n) {
        int[] dp = new int[n + 1];
        int[] moves = new int[n + 1];
        dp[0] = 0;
        moves[0] = 0;
        dp[1] = 1;
        moves[1] = 1;

        if(n >= 2) {
            dp[2] = 1;
            moves[2] = 2;
        }

        for(int i=3; i <= n; i++){
            if((i % 3 == 0) && (i % 2 == 0)){
//                dp[i] = Math.min(dp[i-1] + 1, Math.min(dp[i/3] + 1, dp[i/2] +1));
                if((dp[i-1] <= dp[i/3]) && (dp[i-1] <= dp[i/2])){
                    dp[i] = dp[i-1] + 1;
                    moves[i] = 1;
                }
                else if((dp[i/3] <= dp[i-1]) && (dp[i/3] <= dp[i/2] )){
                    dp[i] = dp[i/3] + 1;
                    moves[i] = 3;
                }
                else if((dp[i/2] <= dp[i-1]) && (dp[i/2] <= dp[i/3] )){
                    dp[i] = dp[i/2] + 1;
                    moves[i] = 2;
                }
            }
            else if(i % 3 == 0){
//                dp[i] = Math.min(dp[i-1] + 1, dp[i/3] + 1);
                if((dp[i-1] <= dp[i/3]) && (dp[i-1] <= dp[i/2])){
                    dp[i] = dp[i-1] + 1;
                    moves[i] = 1;
                }
                else if((dp[i/3] <= dp[i-1]) && (dp[i/3] <= dp[i/2] )){
                    dp[i] = dp[i/3] + 1;
                    moves[i] = 3;
                }
            }
            else if(i % 2 == 0){
//                dp[i] = Math.min(dp[i-1] + 1, dp[i/2] + 1);
                if((dp[i-1] <= dp[i/3]) && (dp[i-1] <= dp[i/2])){
                    dp[i] = dp[i-1] + 1;
                    moves[i] = 1;
                }
                else if((dp[i/2] <= dp[i-1]) && (dp[i/2] <= dp[i/3] )){
                    dp[i] = dp[i/2] + 1;
                    moves[i] = 2;
                }
            }
            else{
                dp[i] = dp[i-1] + 1;
                moves[i] = 1;
            }
        }

//        for(int i=3; i <= n; i++){
//            if((i % 3 == 0) && (i % 2 == 0)){
//                dp[i] = Math.min(dp[i-1] + 1, Math.min(dp[i/3] + 1, dp[i/2] + 1));
//            }
//            else if(i % 3 == 0){
//                dp[i] = Math.min(dp[i-1] + 1, dp[i/3] + 1);
//            }
//            else if(i % 2 == 0){
//                dp[i] = Math.min(dp[i-1] + 1, dp[i/2] + 1);
//            }
//            else{
//                dp[i] = dp[i-1] + 1;
//            }
//        }
/*
        for (int i =0; i < dp.length; i++){
            System.out.println("i=" + i + " dp[i] =" + dp[i] );
        }

        for (int i =0; i < moves.length; i++){
            System.out.println("i=" + i + "moves[i] = " + moves[i]);
        }*/

        List<Integer> sequence = new ArrayList<>();

        int current = n;
        while(current > 0){
            int move = moves[current];
            System.out.println("current = " + current);
            System.out.println("move = " + move);
            sequence.add(current);
            if(move == 1){
                current--;
            }
            else{
                current = current/move;
            }
        }

        Collections.reverse(sequence);
        return sequence;
    }
//    private static List<Integer> optimal_sequence(int n) {
//        List<Integer> sequence = new ArrayList<Integer>();
//        while (n >= 1) {
//            sequence.add(n);
//            if (n % 3 == 0) {
//                n /= 3;
//            } else if (n % 2 == 0) {
//                n /= 2;
//            } else {
//                n -= 1;
//            }
//        }
//        Collections.reverse(sequence);
//        return sequence;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

