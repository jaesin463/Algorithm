import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] tree;
    static int V;
    static Queue<Integer> q = new LinkedList<>();

    static void BFS(int start) {
	q.add(start);
	visited[start] = true;

	while (!q.isEmpty()) {
	    int now = q.poll();
	    for (Edge i : tree[now]) {
		int e = i.e;
		int weight = i.weight;
		if (!visited[e]) {
		    visited[e] = true;
		    q.add(e);
		    distance[e] = distance[now] + weight;
		}
	    }
	}
    }

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	V = init(br.readLine());

	tree = new ArrayList[V + 1];

	for (int i = 1; i < V + 1; i++) {
	    tree[i] = new ArrayList<>();
	}
	// 가중치가 있는 그래프이므로 배열을 넣어줘야 함
	for (int i = 1; i < V; i++) {
	    st = new StringTokenizer(br.readLine());
	    int idx = init(st.nextToken());
	    int node = init(st.nextToken());
	    int weight = init(st.nextToken());
	    tree[idx].add(new Edge(node, weight));
	    tree[node].add(new Edge(idx, weight));
	}

	visited = new boolean[V + 1];
	distance = new int[V + 1];
	BFS(1);
	int max = 1;
	for (int i = 2; i < V + 1; i++) {
	    if (distance[i] > distance[max]) {
		max = i;
	    }
	}
	visited = new boolean[V + 1];
	distance = new int[V + 1];
	BFS(max);
	Arrays.sort(distance);
	System.out.println(distance[V]);
    }

    static class Edge {
	int e;
	int weight;

	public Edge(int e, int weight) {
	    this.e = e;
	    this.weight = weight;
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}
