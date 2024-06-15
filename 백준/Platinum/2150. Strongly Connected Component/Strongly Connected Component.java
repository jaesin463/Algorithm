import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int v, e;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack;

    static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        v = init(st);
        e = init(st);

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        int a, b;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = init(st);
            b = init(st);

            graph.get(a).add(b);
            reverse.get(b).add(a);
        }
    }

    static void solution() {
        visited = new boolean[v + 1];
        stack = new Stack<>();

        for (int i = 1; i < v + 1; i++) {
            if (!visited[i])
                dfs(i);
        }

        Arrays.fill(visited, false);
        int groupNum = 0;

        while (!stack.isEmpty()) {
            int start = stack.pop();

            if (visited[start])
                continue;

            reDfs(start, groupNum);
            groupNum++;
        }

        sb.append(groupNum).append("\n");

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < groupNum; i++) {
            Collections.sort(res.get(i));
            map.put(res.get(i).get(0), i);
        }

        map.keySet().forEach(key -> {
            int value = map.get(key);

            for (int cur : res.get(value)) {
                sb.append(cur).append(" ");
            }
            sb.append("-1\n");
        });

    }

    static void dfs(int start) {
        visited[start] = true;

        for (int cur : graph.get(start)) {
            if (!visited[cur]) {
                dfs(cur);
            }
        }

        stack.push(start);
    }

    static void reDfs(int start, int groupNum) {
        visited[start] = true;
        res.get(groupNum).add(start);

        for (int cur : reverse.get(start)) {
            if (!visited[cur]) {
                reDfs(cur, groupNum);
            }
        }
    }

    static void result() throws IOException {
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
        result();
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}