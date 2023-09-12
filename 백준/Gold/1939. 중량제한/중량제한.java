import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int nIsland, nBridge;
	static int start_factory, end_factory;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, mid;
	static boolean visited[];
	static ArrayList<int[]>[] bridge;

	static boolean BFS(int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start_factory);
		visited[start_factory] = true;
		
		while(!q.isEmpty()) {
			int curIsland = q.poll();
			
			if(curIsland == end_factory)
				return true;
			
			for(int i = 0; i < bridge[curIsland].size(); i++) {
				if(bridge[curIsland].get(i)[1] >= mid && !visited[bridge[curIsland].get(i)[0]]) {
					q.add(bridge[curIsland].get(i)[0]);
					visited[bridge[curIsland].get(i)[0]] = true;;
				}
			}
		}
		
		return false;
	}

	static void solution() {
		int result = 0;

		while (min <= max) {
			visited = new boolean[nIsland + 1];
			mid = min + (max - min) / 2;

			if (BFS(mid)) {
				min = mid + 1;
				result = mid;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(result);
	}

	static void setGraph() throws IOException {
		for (int i = 0; i < nBridge; i++) {
			st = new StringTokenizer(br.readLine());
			int island1 = init(st.nextToken());
			int island2 = init(st.nextToken());
			int limit = init(st.nextToken());
			min = Math.min(min, limit);
			max = Math.max(max, limit);

			bridge[island1].add(new int[] { island2, limit });
			bridge[island2].add(new int[] { island1, limit });
		}
	}

	static void makeGraph() throws IOException {
		bridge = new ArrayList[nIsland + 1];
		for (int i = 0; i <= nIsland; i++) {
			bridge[i] = new ArrayList<>();
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		nIsland = init(st.nextToken());
		nBridge = init(st.nextToken());

		makeGraph();
		setGraph();

		st = new StringTokenizer(br.readLine());
		start_factory = init(st.nextToken());
		end_factory = init(st.nextToken());
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
