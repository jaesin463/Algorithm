import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int v; // 나가는 정점
	int w; // 들어오는 정점
	int cost;

	public Edge(int v, int w, int cost) {
		this.v = v;
		this.w = w;
		this.cost = cost;
	}
}

public class Main {
	static ArrayList<Edge> graph;
	static final int INF = (int) 1e9;

	// 정점의 개수, 간선의 개수, 출발지
	public static boolean BellmanFord(int V, int E, int start) {
		long[] dist = new long[V + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		// 정점의 개수만큼 반복
		for (int i = 0; i < V; i++) {
			// 간선의 개수만큼 반복
			for (int j = 0; j < E; j++) {
				Edge e = graph.get(j); // 현재 간선

				// 현재 간선의 들어오는 정점에 대해 비교
				if (dist[e.v] != INF && dist[e.w] > dist[e.v] + e.cost) {
					dist[e.w] = dist[e.v] + e.cost;
				}
			}
		}

		// 음수 가중치 확인
		for (int i = 0; i < E; i++) {
			Edge e = graph.get(i); // 현재 간선

			// 현재 간선의 들어오는 정점에 대해 비교 -> 더 작은 값 생기면 음수 사이클 존재
			if (dist[e.v] != INF && dist[e.w] > dist[e.v] + e.cost) {
				System.out.println("-1");
				return false;
			}
		}

		// 출력
		for (int i = 2; i < dist.length; i++) {
			if (dist[i] == INF)
				System.out.println("-1");
			else
				System.out.println(dist[i]);
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		// 그래프 입력받기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		// 정점의 개수, 간선의 개수
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.add(new Edge(v, w, cost));
		}

		// 벨만-포드 알고리즘 수행
		BellmanFord(V, E, 1);
	}
}