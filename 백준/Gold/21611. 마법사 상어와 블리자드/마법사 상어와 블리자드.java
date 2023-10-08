import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, len;
	static boolean flag = true;
	static int[] marble;
	static int[] cnt = new int[4];
	static int[][] snail, map;
	static Magic[] magic;
	static Shark shark;
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 주어진 달팽이 방향과 거꾸로 삽입
	public static void makeSnail() {
		snail = new int[N + 1][N + 1];
		marble = new int[len];
		int r = 1;
		int c = 1;
		int count = len - 1;
		int d = 1; // 방향
		while (true) {
			if (count == 0) {
				break;
			}

			marble[count] = map[r][c];
			snail[r][c] = count--;
			int nr = r + dr[d];
			int nc = c + dc[d];
			int nd = setDirection(d, N, nr, nc);
			// 방향이 바뀌면 다음 방향을 기준으로 r,c를 업데이트.
			if (nd != d) {
				r = r + dr[nd];
				c = c + dc[nd];
				d = nd;
			} else {
				r = nr;
				c = nc;
			}
		}
	}

	public static int setDirection(int d, int n, int nr, int nc) {
		// 범위를 벗어났거나
		if (nr > n || nc > n || nr <= 0 || nc <= 0) {
			d = (d + 1) % 4;
		}
		// 이후 있을 자리가 이미 값이 있거나
		else if (snail[nr][nc] != 0) {
			d = (d + 1) % 4;
		}

		return d;
	}

	// 마법 방향과 거리에 따라 구슬 파괴
	static void blizzard(int n) {
		int dir = magic[n].d;
		int r = shark.r;
		int c = shark.c;
		for (int i = 0; i < magic[n].s; i++) {
			r += dr[dir];
			c += dc[dir];

			marble[snail[r][c]] = 0;
		}
	}

	// 구슬 파괴 후 빈칸 땡기기
	static int[] moveMarble() {
		int[] nextMarble = new int[len];

		int idx = 1;

		for (int i = 1; i < len; i++) {
			if (marble[i] != 0)
				nextMarble[idx++] = marble[i];
		}
		return nextMarble;
	}

	// 구슬 이동 후 4개 이상 연속 시 폭발
	static boolean bombMarble(int[] nextMarble) {
		flag = false;
		int color = nextMarble[1];
		int count = 1;
		for (int i = 2; i < len; i++) {
			if (nextMarble[i] == color)
				count++;
			else {
				if (count >= 4) {
					cnt[color] += count;
					for (int j = 1; j < count + 1; j++) {
						nextMarble[i - j] = 0;
					}
					flag = true;
				}
				color = nextMarble[i];
				count = 1;
			}
		}
		marble = nextMarble.clone();
		return flag;
	}

	// 연속하는 구슬의 개수와 색상으로 새로운 맵 생성
	static void changeMarble() {
		int[] nextMarble = new int[len];
		int color = marble[1];
		int count = 1;
		int idx = 1;
		for (int i = 2; i < len; i++) {
			if (marble[i] == color)
				count++;
			else {
				nextMarble[idx++] = count;
				nextMarble[idx++] = color;
				if (idx == len)
					break;

				color = marble[i];
				count = 1;
				if (color == 0)
					break;
			}
		}
		marble = nextMarble.clone();
	}

	static void solution() {
		for (int i = 0; i < M; i++) {
			blizzard(i);
			while (flag) {
				bombMarble(moveMarble());
			}
			flag = true;
			changeMarble();
		}
		System.out.println(cnt[1] + (2 * cnt[2]) + (3 * cnt[3]));
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		M = init(st);
		len = N * N;
		map = new int[N + 1][N + 1];
		shark = new Shark((N + 1) / 2, (N + 1) / 2);

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = init(st);
			}
		}

		makeSnail();

		magic = new Magic[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			magic[i] = new Magic(init(st), init(st));
			// 상 우 하 좌
			if (magic[i].d == 1)
				magic[i].d = 0;
			else if (magic[i].d == 2)
				magic[i].d = 2;
			else if (magic[i].d == 3)
				magic[i].d = 3;
			else
				magic[i].d = 1;
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static class Shark {
		int r, c;

		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Magic {
		int d, s;

		public Magic(int d, int s) {
			this.d = d;
			this.s = s;
		}
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}