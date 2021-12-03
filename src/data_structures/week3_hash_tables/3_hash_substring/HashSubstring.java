import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String pattern = input.pattern, text = input.text;
        int m = pattern.length(), n = text.length();
        List<Integer> occurrences = new ArrayList<Integer>();

        long prime = ;// TODO big prime
//        long phash = polyHash(x, prime);
        long[] h = precomputeHashes(text, pattern, prime );
        for (int i = 0; i + m <= n; ++i) {
            // TODO compare precomupte hash and continue if they don't match
            if(pHash != h[i])
                continue;

            if (areEqual(pattern, text, m, i))
                occurrences.add(i);
	    }
        return occurrences;
    }

    private static long polyHash(long x, long prime) {
        return (32*x + 2) % prime;
    }

    private static long[] precomputeHashes(String text, String pattern, int prime){
        long[] result = new long[text.length() - pattern.length() + 1];
            // TODO  what is x here??
        String s = text.substring(text.length() - pattern.length());
        int y =1;
        for (int i = 1; i < pattern.length(); i++) {
            y = (y*x) % prime;
        }
        for (int i = text.length()-pattern.length()-1; i >=0 ; i--) {
            result[i] = (x*result[i+1] + text.charAt(i) - y * text.charAt(i+pattern.length())) % prime;
        }
        
        return result;
    }

    private static boolean areEqual(String s, String t, int m, int i) {
        boolean equal = true;
        for (int j = 0; j < m; ++j) {
        if (s.charAt(j) != t.charAt(i + j)) {
             equal = false;
            break;
        }
        }
        return equal;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

