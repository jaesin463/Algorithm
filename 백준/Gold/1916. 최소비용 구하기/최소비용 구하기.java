import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Edge>[] graph;
	static int[] dis;
	static boolean[] visited;
	static int V, E;
	static PriorityQueue<Edge> q = new PriorityQueue<>();

	static boolean BFS() {
		while (!q.isEmpty()) {
			Edge now = q.poll();
			// 사실상 최종 출력을 위한 방문 처리
			if (visited[now.vertex])
				continue;
			visited[now.vertex] = true;
			// 현재 정점과 연결된 정점들을 큐에 추가
			for (int i = 0; i < graph[now.vertex].size(); i++) {
				// 다음 정점까지에 대한 정보
				Edge temp = graph[now.vertex].get(i);
				int next = temp.vertex;
				int weight = temp.weight;
				// 다음 정점까지 가는 거리가 이번에 가는 방법이 더 최단거리인 경우
				if (dis[next] > dis[now.vertex] + weight) {
					dis[next] = dis[now.vertex] + weight;
					q.add(new Edge(next, dis[next]));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 정점 개수
		V = init(br.readLine());
		// 간선 개수
		E = init(br.readLine());
		// 각 배열의 크기를 노드의 개수에 맞추어 설정
		graph = new ArrayList[V + 1];
		dis = new int[V + 1];
		visited = new boolean[V + 1];
		// 그래프 초기화
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		// 최솟값으로 거리를 비교할 예정이므로 거리 배열 초기화
		for (int i = 0; i <= V; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		// 가중치가 있는 인접 리스트의 표현
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int now = init(st.nextToken());
			int next = init(st.nextToken());
			int weight = init(st.nextToken());
			graph[now].add(new Edge(next, weight));
		}
		st = new StringTokenizer(br.readLine());
		// 시작 정점
		int start = init(st.nextToken());
		// 종료 정점
		int end = init(st.nextToken());
		// 시작 정점 큐에 추가
		q.add(new Edge(start, 0));
		// 가중치를 더해나갈 예정이므로 시작은 0
		dis[start] = 0;

		BFS();

		if (visited[end]) {
			System.out.println(dis[end]);
		} else {
			System.out.println("-1");
		}
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}

class Edge implements Comparable<Edge> {
	int vertex;
	int weight;

	public Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.weight > o.weight)
			return 1;
		return -1;
	}
}