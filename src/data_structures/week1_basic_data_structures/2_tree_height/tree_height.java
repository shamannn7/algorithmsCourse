import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class tree_height {
    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }

    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeHeight {
        int n;
        int[] parent;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

		int computeHeight() {
			// Replace this code with a faster implementation
			//Breadth First Search
			int maxHeight = 0;

			if(parent == null || parent.length == 0){
				return 0;
			}
			//find root
			Map<Integer, List<Integer>> tree = new HashMap<>();

			//build tree
			for (int i = 0; i < parent.length; i++) {
                List<Integer> children = null;
                if (parent[i] != -1) {
                    children = tree.get(parent[i]);
                }
                if(children == null){
                    children = new LinkedList<>();
                }
                children.add(i);

                tree.put(parent[i], children);
            }

			//find height
			Queue<Integer> q = new LinkedList<>();
			List<Integer> rootChildren = tree.get(-1);
            if(rootChildren != null){
                q.addAll(rootChildren);
                maxHeight++;
            }
			while (!q.isEmpty()){

				Integer next = q.poll();
                List<Integer> children = tree.get(next);
                if(children != null){
                    maxHeight++;
                    q.addAll(children);
                }
			}

//			for (int vertex = 0; vertex < n; vertex++) {
//				int height = 0;
//				for (int i = vertex; i != -1; i = parent[i])
//					height++;
//				maxHeight = Math.max(maxHeight, height);
//			}
			return maxHeight;
		}
//        int computeHeight() {
//            // Replace this code with a faster implementation
//            int maxHeight = 0;
//            for (int vertex = 0; vertex < n; vertex++) {
//                int height = 0;
//                for (int i = vertex; i != -1; i = parent[i])
//                    height++;
//                maxHeight = Math.max(maxHeight, height);
//            }
//            return maxHeight;
//        }
    }
}
