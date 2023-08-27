import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int blank = 0;
	static final int wall = -1;
	static int N, M, fuel;
	static guest[] guests;
	static Queue<Integer>[][] guestMap;
	static Taxi taxi;
	static int[][] map;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static boolean nextGuest() {
		ArrayList<Taxi> T = new ArrayList<>();
		Queue<Taxi> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		queue.offer(taxi);
		visited[taxi.r][taxi.c] = true;
		while (!queue.isEmpty()) {
			Taxi now = queue.poll();
			// 모든 승객들을 태운것을 고려해서 가장먼저 태운 승객보 compareTo로 time이 더 걸린다 continue
			if (!T.isEmpty() && T.get(0).time < now.time)
				continue;
			// 시간이 덜 걸린다면 add
			if (!guestMap[now.r][now.c].isEmpty()) {
				T.add(now);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int r = now.r + dr[i];
				int c = now.c + dc[i];
				if (r < 1 || r > N || c < 1 || c > N || visited[r][c] || map[r][c] == -1)
					continue;

				visited[r][c] = true;
				queue.offer(new Taxi(r, c, now.time + 1));
			}
		}
		if (T.isEmpty())
			return false;
		// 컬렉션sort해서 한번 더 검사
		Collections.sort(T);

		taxi = T.get(0);
		return true;
	}

	static boolean nextDestination(int x, int y) {
		Queue<Taxi> queue = new LinkedList<>();
		queue.offer(taxi);
		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[taxi.r][taxi.c] = true;

		while (!queue.isEmpty()) {
			Taxi now = queue.poll();
			if (now.r == x && now.c == y) {
				taxi = now;
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int r = now.r + dr[i];
				int c = now.c + dc[i];
				if (r < 1 || c < 1 || r > N || c > N || visited[r][c] || map[r][c] == -1)
					continue;

				visited[r][c] = true;
				queue.offer(new Taxi(r, c, now.time + 1));
			}
		}
		return false;
	}

	static int solution() {
		for (int i = 0; i < M; i++) {
			if (!nextGuest()) {
				return -1;
			}
			int time = taxi.time;
			int idx = guestMap[taxi.r][taxi.c].poll();

			if (!nextDestination(guests[idx].destinationR, guests[idx].destinationC)) {
				return -1;
			}
			fuel -= taxi.time;

			if (fuel < 0) {
				return -1;
			} else {
				fuel += (2 * (taxi.time - time));
				taxi.time = 0;
			}
		}
		return fuel;
	}

	static void make() throws IOException {

		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());
		fuel = init(st.nextToken());
		map = new int[N + 1][N + 1];
		guests = new guest[M + 1];
		guestMap = new LinkedList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				guestMap[i][j] = new LinkedList<Integer>();
				map[i][j] = init(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = wall;
			}
		}
		makeTaxi();
		makeGuest();
	}

	static void makeTaxi() throws IOException {
		st = new StringTokenizer(br.readLine());
		taxi = new Taxi(init(st.nextToken()), init(st.nextToken()), 0);
	}

	static void makeGuest() throws IOException {
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			guests[i] = new guest(init(st.nextToken()), init(st.nextToken()), init(st.nextToken()),
					init(st.nextToken()), i);
			guestMap[guests[i].positionR][guests[i].positionC].add(i);
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		System.out.println(solution());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}

class Taxi implements Comparable<Taxi> {
	int r;
	int c;
	int time;

	public Taxi(int r, int c, int time) {
		this.r = r;
		this.c = c;
		this.time = time;
	}

	public int compareTo(Taxi o) {
		if (this.time == o.time) {
			if (this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}
		return this.time - o.time;
	}
}

class guest {
	int positionR;
	int positionC;
	int destinationR;
	int destinationC;
	int idx;

	public guest(int positionR, int positionC, int destinationR, int destinationC, int idx) {
		this.positionR = positionR;
		this.positionC = positionC;
		this.destinationR = destinationR;
		this.destinationC = destinationC;
		this.idx = idx;
	}
}