import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, result;
    static int[][] plane;
    static boolean[] visited;

    public static void solution() {
        result = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            result++;
            int value = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (plane[value][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        sb.append(result - 1).append("\n");
    }

    static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        plane = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            plane[u][v] = 1;
            plane[v][u] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = init();
        for (int i = 0; i < T; i++) {
            make();
            solution();
        }
        System.out.print(sb);
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}