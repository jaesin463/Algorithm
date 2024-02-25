import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static int[] deep;
    static int N, M;

    public static void solution() throws IOException {
        M = init();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = init(st);
            int node2 = init(st);

            sb.append(LCA(node1, node2)).append("\n");
        }

        System.out.print(sb);
    }

    private static int LCA(int a, int b) {
        // 같은 층으로 만들기
        while (deep[a] > deep[b]) { // a가 더 밑에 있다면
            a = parent[a];
        }
        while (deep[a] < deep[b]) { //b가 더 밑에 있다면
            b = parent[b];
        }

        // 같은 층인데 같지 않다면(부모가 다르다면)
        while (a != b) { // 같은 부모를 찾을 때 까지 반복
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    static void make() throws IOException {
        N = init();
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        parent = new int[N + 1];
        deep = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = init(st);
            int node2 = init(st);

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        dfs(1, 1);
    }

    public static void dfs(int current, int depth) {
        deep[current] = depth;

        for (int next : tree[current]) {
            if (deep[next] == 0) {
                dfs(next, depth + 1);
                parent[next] = current;
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