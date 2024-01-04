import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] inDegree, time, timeMemo;
    static ArrayList<Integer>[] priority;

    static void solution() throws IOException {
        Queue<Integer> q = new LinkedList<>();

        timeMemo = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            timeMemo[i] = time[i];

            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : priority[now]) {
                timeMemo[next] = Math.max(timeMemo[next], timeMemo[now] + time[next]);
                if (--inDegree[next] == 0)
                    q.offer(next);
            }

        }

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            result = Math.max(result, timeMemo[i]);
        }

        System.out.println(result);
    }

    static void make() throws IOException {
        N = init();

        time = new int[N + 1];
        inDegree = new int[N + 1];
        priority = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            priority[i] = new ArrayList<>();
        }

        int pre;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = init(st);

            pre = init(st);

            for (int j = 0; j < pre; j++) {
                int temp = init(st);
                priority[temp].add(i);

                inDegree[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

}