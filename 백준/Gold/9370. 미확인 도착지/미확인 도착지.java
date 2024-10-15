import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int INF = 10_000_000;
    static int T;
    static int n, m, t, s, g, h, a, b, d;
    static int[][] graph;
    static int[] dist;
    static boolean[] visited;
    static List<Integer> dest;

    static void solution() {
        dijkstra();
        Collections.sort(dest);
        for (int num : dest) {
            if (dist[num] % 2 == 1)
                sb.append(num).append(" ");
        }
        sb.append("\n");
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(s, 0));
        dist[s] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;
            if (visited[cur]) continue;
            visited[cur] = true;

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && dist[i] > dist[cur] + graph[cur][i]) {
                    dist[i] = dist[cur] + graph[cur][i];
                    queue.add(new Node(i, dist[i]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        T = init();
        for(int i = 0; i < T; i++) {
            make();
            solution();
        }
        System.out.println(sb);
    }

    static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = init(st);
        m = init(st);
        t = init(st);

        st = new StringTokenizer(br.readLine());
        s = init(st);
        g = init(st);
        h = init(st);

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = init(st);
            int v2 = init(st);
            int dis = 2 * init(st);
            graph[v1][v2] = graph[v2][v1] = dis;
        }

        graph[h][g] = graph[g][h] = graph[g][h] - 1;

        dest = new ArrayList<>();
        for (int i = 0; i < t; i++)
            dest.add(init());
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) throws IOException {
        return Integer.parseInt(st.nextToken());
    }
}
