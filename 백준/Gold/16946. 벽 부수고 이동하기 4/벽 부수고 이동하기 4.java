import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[] blank;
	static Queue<int[]> q = new LinkedList<>();

	static void BFS(int a, int b, int idx) {
		cnt = 1;
		map[a][b] = idx;
		visited[a][b] = true;
		q.add(new int[] { a, b });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int r = x + dr[i];
				int c = y + dc[i];

				if (r >= 0 && r < N && c >= 0 && c < M) {
					if (!visited[r][c] && map[r][c] == 0) {
						visited[r][c] = true;
						map[r][c] = idx;
						q.add(new int[] { r, c });
						cnt++;
					}
				}
			}
		}
	}

	static void setting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					Set<Integer> group = new HashSet<>();
					for (int k = 0; k < 4; k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						if (r >= 0 && r < N && c >= 0 && c < M) {
							if (map[r][c] != -1)
								group.add(map[r][c]);
						}
					}
					int sum = 1;
					for (Integer l : group) {
						sum += blank[l];
					}
					sb.append(String.valueOf(sum % 10));
				} else {
					sb.append("0");
				}
			}
			sb.append("\n");
		}
	}

	static void groupblank() {
		int idx = 1;
		visited = new boolean[N][M];
		blank = new int[N * M + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					BFS(i, j, idx);
					blank[idx++] = cnt;
				}
			}
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		groupblank();
		setting();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
