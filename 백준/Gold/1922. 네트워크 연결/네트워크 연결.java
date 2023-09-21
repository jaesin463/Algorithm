import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int v;
	int cost;
	
	Edge(int  v, int cost){
		this.v = v;
		this.cost = cost;
	}
	
	// 우선순위 큐 정렬 기준(가중치의 오름차순)
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static ArrayList<Edge>[] graph;
	
	public static void prim(int start, int N) {
		boolean[] visited = new boolean[N + 1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		// 최종 가중치의 총합
		int result = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.v;
			int cost = edge.cost;
			
			// 이미 방문한 정점인 경우 다음 간선
			if(visited[v]) continue;
            
			visited[v] = true;
			result += cost;
			
			// 새로 연결한 정점과 연결된 간선들을 우선 순위큐에 추가
			for(Edge e : graph[v]) {
				if(!visited[e.v]) {
					pq.add(e);
				}
			}
		}
		System.out.println(result);
	}

	static void makeGraph() throws IOException {
   		// 그래프 입력, 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Vertex = init(br.readLine());
		int Edge = init(br.readLine());
		
        // 그래프 선언, 간선 리스트로 표현
		graph = new ArrayList[Vertex + 1];
		for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < Edge; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = init(st.nextToken());
			int v2 = init(st.nextToken());
			int cost = init(st.nextToken());
			// 무방향 그래프
			graph[v1].add(new Edge(v2, cost));
			graph[v2].add(new Edge(v1, cost));
		}
		
		// 프림 알고리즘 수행
		prim(1, Vertex);
	}
	
	public static void main(String[] args) throws IOException {
		makeGraph();
	}
	
	static int init(String str) {
		return Integer.parseInt(str);
	}
}