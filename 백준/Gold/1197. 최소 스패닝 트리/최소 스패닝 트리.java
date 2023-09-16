import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static int result = 0;
	static boolean[] visited;
	static List<Vertex>[] graph;

	static void solution(int start) {
		Queue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(start, 0));

		while (!pq.isEmpty()) {
			Vertex now = pq.poll();

			if (visited[now.next])
				continue;
			visited[now.next] = true;
			result += now.value;

			for (Vertex v : graph[now.next]) {
				if (!visited[v.next]) {
					pq.add(v);
				}
			}
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		V = init(st.nextToken());
		E = init(st.nextToken());

		graph = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int now = init(st.nextToken());
			int next = init(st.nextToken());
			int value = init(st.nextToken());

			graph[now].add(new Vertex(next, value));
			graph[next].add(new Vertex(now, value));
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution(1);
		System.out.println(result);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static class Vertex implements Comparable<Vertex> {
		int next;
		int value;

		public Vertex(int next, int value) {
			this.next = next;
			this.value = value;
		}

		@Override
		public int compareTo(Vertex v) {
			return this.value - v.value;
		}
	}

}