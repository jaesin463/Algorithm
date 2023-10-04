import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// 낚시터 크기, 상어 마리수
	static int R, C, M;
	static int get = 0;
	static Shark[][] fishing;
	// 0 : 북, 1 : 동, 2 : 남, 3 : 서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static void sharkMove() {
		Queue<Shark> q = new LinkedList<>();
		// 주어진 속도(s)로 방향(d)대로 이동
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (fishing[i][j] != null) {
					q.add(fishing[i][j]);
				}
			}
		}

		fishing = new Shark[R + 1][C + 1];

		while (!q.isEmpty()) {
			Shark curS = q.poll();

			for (int s = 0; s < curS.s; s++) {
				int r = curS.r + dr[curS.d];
				int c = curS.c + dc[curS.d];

				if (r <= 0 || r > R || c <= 0 || c > C) {
					curS.r -= dr[curS.d];
					curS.c -= dc[curS.d];
					curS.d = (curS.d + 2) % 4;
					continue;
				}
				curS.r = r;
				curS.c = c;
			}

			int r = curS.r;
			int c = curS.c;

			if (fishing[r][c] != null) {
				if (fishing[r][c].z > curS.z) {
					continue;
				}
			}
			fishing[r][c] = curS;
		}
	}

	static void solution() {
		// 낚시왕이 오른쪽으로 한 칸 이동 (시작위치 0)
		for (int i = 1; i < C + 1; i++) {
			// 낚시왕이 열에 있는 상어 중에서 행의 크기가 가장 작은 상어 Get
			for (int j = 1; j < R + 1; j++) {
				if (fishing[j][i] != null) {
					get += fishing[j][i].z;
					fishing[j][i] = null;
					break;
				}
			}
			// 상어 이동
			sharkMove();
		}
		System.out.println(get);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = init(st);
		C = init(st);
		M = init(st);

		fishing = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// r, c, s, d, z
			int r = init(st);
			int c = init(st);
			int s = init(st);
			int d = init(st) - 1;
			int z = init(st);

			if (d == 1)
				d = 2;
			else if (d == 2)
				d = 1;

			Shark shark = new Shark(r, c, s, d, z);

			fishing[shark.r][shark.c] = shark;
		}

	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static class Shark {
		int r, c, s, d, z;

		// (r,c) : 위치, s : 속력, d : 이동방향, z : 크기
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
