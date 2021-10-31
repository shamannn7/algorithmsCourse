import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int tens = m/10;
        m -= 10*tens;
        int fives = m/ 5;
        m -= 5*fives;

        return tens + fives + m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

