import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static long result = 0;
	static int[][] temp;
	static boolean[] visited;
	static Planet[] p;
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
		V = init(br.readLine());
		p = new Planet[V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new Planet(i, init(st.nextToken()), init(st.nextToken()), init(st.nextToken()));
		}
		makeGraph();
	}

	static void makeGraph() throws IOException {
//		st = new StringTokenizer(br.readLine());
//		E = init(br.readLine());

		graph = new ArrayList[V];
		visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}

//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//			int now = init(st.nextToken());
//			int next = init(st.nextToken());
//			int value = init(st.nextToken());
//
//			graph[now].add(new Vertex(next, value));
//			graph[next].add(new Vertex(now, value));
//		}

		Arrays.sort(p, (o1, o2) -> (o1.x - o2.x));
		for (int i = 1; i < V; i++) {
			Planet p1 = p[i];
			Planet p2 = p[i - 1];
			int weight = Math.abs(p1.x - p2.x);
			graph[p1.idx].add(new Vertex(p2.idx, weight));
			graph[p2.idx].add(new Vertex(p1.idx, weight));
		}
		Arrays.sort(p, (o1, o2) -> (o1.y - o2.y));
		for (int i = 1; i < V; i++) {
			Planet p1 = p[i];
			Planet p2 = p[i - 1];
			int weight = Math.abs(p1.y - p2.y);
			graph[p1.idx].add(new Vertex(p2.idx, weight));
			graph[p2.idx].add(new Vertex(p1.idx, weight));
		}
		Arrays.sort(p, (o1, o2) -> (o1.z - o2.z));
		for (int i = 1; i < V; i++) {
			Planet p1 = p[i];
			Planet p2 = p[i - 1];
			int weight = Math.abs(p1.z - p2.z);
			graph[p1.idx].add(new Vertex(p2.idx, weight));
			graph[p2.idx].add(new Vertex(p1.idx, weight));
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

	static class Planet {
		int idx, x, y, z;

		public Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}