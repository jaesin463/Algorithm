import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] fish;
	static int[][] dis;
	static int[] start = new int[2];
	static int[] minxy;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static Baby baby;
	static int min;

	static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		fish[r][c] = 0;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = now[0] + dr[i];
				int dy = now[1] + dc[i];

				if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if (fish[dx][dy] <= baby.size && dis[dx][dy] == 0) {
						dis[dx][dy] = dis[now[0]][now[1]] + 1;
						queue.add(new int[] { dx, dy });
						if (fish[dx][dy] >= 1 && fish[dx][dy] < baby.size) {
							if (min > dis[dx][dy]) {
								min = dis[dx][dy];
								minxy[0] = dx;
								minxy[1] = dy;
							} else if (min == dis[dx][dy]) {
								if (dx == minxy[0]) {
									if (dy < minxy[1]) {
										minxy[0] = dx;
										minxy[1] = dy;
									}
								} else if (dx < minxy[0]) {
									minxy[0] = dx;
									minxy[1] = dy;
								}
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = init(br.readLine());
		fish = new int[N][N];
		baby = new Baby(2, 0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				fish[i][j] = init(st.nextToken());
				if (fish[i][j] == 9) {
					start[0] = i;
					start[1] = j;
					fish[i][j] = 0;
				}

			}
		}
		int result = 0;
		while (true) {
			dis = new int[N][N];
			minxy = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
			min = Integer.MAX_VALUE;

			BFS(start[0], start[1]);

			if (minxy[0] != Integer.MAX_VALUE && minxy[1] != Integer.MAX_VALUE) {
				baby.eat++;
				if (baby.eat == baby.size) {
					baby.size++;
					baby.eat = 0;
				}
				start[0] = minxy[0];
				start[1] = minxy[1];
				result += dis[start[0]][start[1]];
			} else {
				break;
			}
		}

		System.out.println(result);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - 'A';
	}
}

class Baby {
	int size;
	int eat;

	public Baby(int size, int eat) {
		this.size = size;
		this.eat = eat;
	}
}