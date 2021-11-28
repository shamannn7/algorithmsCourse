import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Tuple{
    long time;
    int id;
    Tuple(int time, int id){
        this.time = time;
        this.id = id;
    }
}

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }
    private void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];

        Comparator<Tuple> myComparator = (Tuple o1, Tuple o2) -> {
            if (o1.time == o2.time) {
                return Integer.compare(o1.id, o2.id);
            } else {
                return Long.compare(o1.time, o2.time);
            }
        };

        PriorityQueue<Tuple> workersQ = new PriorityQueue<>(myComparator);
        for (int i = 0; i < numWorkers; i++) {
            workersQ.add(new Tuple(0, i));
        }

        PriorityQueue<Tuple> jobsQ = new PriorityQueue<>(myComparator);
        for (int i = 0; i < jobs.length; i++) {
            jobsQ.add(new Tuple(jobs[i], i));
        }

        int i = 0;
        while (!jobsQ.isEmpty() && !workersQ.isEmpty()){
            Tuple currentJob = jobsQ.poll();
            Tuple currentWorker = workersQ.poll(); // TODO poll only threads which finished

            assignedWorker[i] = currentWorker.id;
            startTime[i] = currentWorker.time;

            currentWorker.time = startTime[i] + currentJob.time;//updating finishing time
            workersQ.add(currentWorker);
            i++;
        }
    }

//        private void assignJobs() {
//        // TODO: replace this code with a faster algorithm.
//    assignedWorker = new int[jobs.length];
//    startTime = new long[jobs.length];
//        long[] nextFreeTime = new long[numWorkers];
//        for (int i = 0; i < jobs.length; i++) {
//            int duration = jobs[i];
//            int bestWorker = 0;
//            for (int j = 0; j < numWorkers; ++j) {
//                if (nextFreeTime[j] < nextFreeTime[bestWorker])
//                    bestWorker = j;
//            }
//            assignedWorker[i] = bestWorker;
//            startTime[i] = nextFreeTime[bestWorker];
//            nextFreeTime[bestWorker] += duration;
//        }
//    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
