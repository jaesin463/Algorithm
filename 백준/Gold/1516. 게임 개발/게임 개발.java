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
        for (int i = 1; i < N + 1; i++)
            if (inDegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int question = q.poll();

            for (int num : priority[question]) {
                inDegree[num]--;
                timeMemo[num] = Math.max(timeMemo[num], timeMemo[question] + time[question]);
                if (inDegree[num] == 0) {
                    q.add(num);
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            sb.append(timeMemo[i] + time[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = init(st);

        inDegree = new int[N + 1];
        time = new int[N + 1];
        timeMemo = new int[N + 1];
        priority = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            priority[i] = new ArrayList<>();
        }

        int before;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = init(st);

            before = init(st);
            while (before != -1) {
                priority[before].add(i);
                inDegree[i]++;
                before = init(st);
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