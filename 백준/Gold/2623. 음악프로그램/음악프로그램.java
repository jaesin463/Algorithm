import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, Sub;
	// 1. 정점에 들어오는 간선 수(진입 차수) 저장
	static int[] in_degree;
	static ArrayList<Integer>[] graph;
	static List<Integer> result = new ArrayList<>();

	// BFS를 이용한 위상 정렬
	static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < V + 1; i++)
			// 3. 진입 차수가 0인 정점을 큐에 추가
			if (in_degree[i] == 0)
				q.offer(i);

		// 7. 결과의 크기는 정점의 수여야 하기 때문에 정점의 수만큼 반복
		for (int i = 1; i < V + 1; ++i) {
			// *. 반복문이 다 돌기전에 큐가 비었다는 것은 사이클이 존재한다는 의미
			if (q.isEmpty()) {
				System.out.println("0");
				return;
			}

			// 4. 큐에 들어있던 정점을 결과 배열에 추가
			int now = q.poll();
			result.add(now);

			// 이번에 꺼낸 정점과 연결된 정점을 확인
			for (int j = 0; j < graph[now].size(); j++) {
				int next = graph[now].get(j);
				// 5. 연결된 정점의 진입차수를 1 감소
				// 6. 집입 차수가 0이 되었다면, 큐에 추가
				if (--in_degree[next] == 0)
					q.offer(next);
			}
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		V = init(st.nextToken());
		// 보조의 수
		Sub = init(st.nextToken());
		in_degree = new int[V + 1];
		// 그래프 생성
		graph = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		// 간선 추가
		for (int i = 0; i < Sub; i++) {
			st = new StringTokenizer(br.readLine());
			int num = init(st.nextToken());
			int from = init(st.nextToken());
			for (int j = 0; j < num - 1; j++) {
				int to = init(st.nextToken());
				graph[from].add(to);
				// 2. 정점 to의 진입 차수 증가
				in_degree[to]++;
				from = to;
			}
		}
	}

	static void solution() {
		TopologicalSort();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}