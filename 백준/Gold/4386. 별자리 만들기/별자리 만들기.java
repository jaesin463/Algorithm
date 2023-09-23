import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int v;
	double cost;

	Edge(int v, double cost) {
		this.v = v;
		this.cost = cost;
	}

	// 1. 우선순위 큐 정렬 기준(가중치의 오름차순)
	@Override
	public int compareTo(Edge o) {
		return (int) (this.cost - o.cost);
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static double[][] planet;
	static ArrayList<Edge>[] graph;

	public static void prim(int start, int N) {
		boolean[] visited = new boolean[N + 1];

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 1. 시작 정점을 추가
		pq.offer(new Edge(start, 0));

		// 최종 가중치의 총합
		double result = 0;

		while (!pq.isEmpty()) {
			// 2. 연결된 정점들의 간선등 중 가중치가 낮은 간선 선택
			Edge edge = pq.poll();
			int v = edge.v;
			double cost = edge.cost;

			// 2. 이미 방문한 정점인 경우 다음 간선
			if (visited[v])
				continue;

			visited[v] = true;
			result += cost;

			// 새로 연결한 정점과 연결된 간선들을 우선 순위큐에 추가
			for (Edge e : graph[v]) {
				if (!visited[e.v]) {
					pq.add(e);
				}
			}
		}
		System.out.println(result);
	}

	static void makeGraph() throws IOException {
		make();
		// 그래프 선언, 간선 리스트로 표현
		graph = new ArrayList[N + 1];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();

		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				double cost = distance(planet[i], planet[j]);
				// 무방향 그래프
				graph[i].add(new Edge(j, cost));
				graph[j].add(new Edge(i, cost));
			}
		}

		// 프림 알고리즘 수행
		prim(1, N);
	}

	static void make() throws IOException {
		N = Integer.parseInt(br.readLine());
		planet = new double[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			planet[i][0] = init(st.nextToken());
			planet[i][1] = init(st.nextToken());
		}
	}

	static double distance(double[] a, double[] b) {
		double dy = Math.abs(a[0] - b[0]);
		double dx = Math.abs(a[1] - b[1]);
		return Math.round(Math.sqrt(dy * dy + dx * dx) * 100) / 100.0;
	}

	public static void main(String[] args) throws IOException {
		makeGraph();
	}

	static double init(String str) {
		return Double.parseDouble(str);
	}
}