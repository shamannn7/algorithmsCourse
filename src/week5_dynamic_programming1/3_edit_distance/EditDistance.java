import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int[][] distanceMatrix = new int[s.length() + 1][t.length() + 1];

    //fiiling borders
    for (int i=0; i<=s.length();i++){
//      System.out.println("i = " + i);
      distanceMatrix[i][0] = i;
    }
    for (int i=1; i<=t.length();i++){
//      System.out.println("2 i = " + i);
      distanceMatrix[0][i] = i;
    }

    for (int i=1; i<=s.length();i++){
      for (int j=1; j<=t.length();j++){
        int insert = distanceMatrix[i][j-1] + 1;
        int delete = distanceMatrix[i-1][j] + 1;
        int noMatch = distanceMatrix[i-1][j-1] + 1;
        int match = distanceMatrix[i-1][j-1];

//        System.out.println("insert = " + insert);
//        System.out.println("delete = " + delete);
//        System.out.println("noMatch = " + noMatch);
//        System.out.println("match = " + match);
//
//        System.out.println("s.charAt(i) = " + s.charAt(i-1));
//        System.out.println("t.charAt(j) = " + t.charAt(j-1));
        if(s.charAt(i-1) == t.charAt(j-1)){
          distanceMatrix[i][j] = Math.min(insert, Math.min(delete, match));
        }
        else{
          distanceMatrix[i][j] = Math.min(insert, Math.min(delete, noMatch));
        }

//        System.out.println("distanceMatrix[" +  i+"][" + j+"] = " + distanceMatrix[i][j]);
     }
    }

    return distanceMatrix[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
