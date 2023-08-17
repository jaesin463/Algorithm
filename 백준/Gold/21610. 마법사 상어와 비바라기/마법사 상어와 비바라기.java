import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String ru;
    static int N;
    static int M;
    static int[][] basket;
    static boolean[][] cloud;
    static boolean[][] mcloud;
    // 1번 부터 di
    static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

    // (r, c) (1, 1) -> (N, N)

    // 최초 비바라기 (N, 1) (N, 2) (N - 1, 1) (N - 1 , 2)
    static void firstCloud() {
	cloud[N - 1][0] = true;
	cloud[N - 1][1] = true;
	cloud[N - 2][0] = true;
	cloud[N - 2][1] = true;
    }

    // direction 방향으로 time번 이동 후 물의 양 1 증가 (양 끝은 연결)
    static void moveCloud(int direction, int time) {
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		if (cloud[i][j]) {
		    cloud[i][j] = false;
		    int idxr = i + (dr[direction - 1] * time);
		    if (idxr < 0) {
			while (idxr < 0) {
			    idxr = idxr + N;
			}
		    } else if (idxr >= N) {
			while (idxr >= N) {
			    idxr = idxr - N;
			}
		    }
		    int idxc = j + (dc[direction - 1] * time);
		    if (idxc < 0) {
			while (idxc < 0) {
			    idxc = idxc + N;
			}
		    } else if (idxc >= N) {
			while (idxc >= N) {
			    idxc = idxc - N;
			}
		    }
		    mcloud[idxr][idxc] = true;
		    basket[idxr][idxc]++;
		}
	    }
	}

	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		if (mcloud[i][j]) {
		    cloud[i][j] = true;
		    mcloud[i][j] = false;
		} else {
		    cloud[i][j] = false;
		}
	    }
	}
    }

    /*
     * 물 복사 버그 (r, c) 의 대간선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c) 물 증가
     */
    static void copyWater() {
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		if (cloud[i][j]) {
		    // 좌상단
		    if (i > 0 && j > 0 && basket[i - 1][j - 1] != 0) {
			basket[i][j]++;
		    }
		    // 우상단
		    if (i > 0 && j < N - 1 && basket[i - 1][j + 1] != 0) {
			basket[i][j]++;
		    }
		    // 좌하단
		    if (i < N - 1 && j > 0 && basket[i + 1][j - 1] != 0) {
			basket[i][j]++;
		    }
		    // 우하단
		    if (i < N - 1 && j < N - 1 && basket[i + 1][j + 1] != 0) {
			basket[i][j]++;
		    }
		}
	    }
	}
    }

    /*
     * 구름 생성 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양 2 줄어듬 이번턴에 구름이 사라진 칸이 아니어야 한다
     */
    static void makeCloud() {
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		if (basket[i][j] >= 2) {
		    if (!cloud[i][j]) {
			cloud[i][j] = true;
			basket[i][j] -= 2;
		    } else {
			cloud[i][j] = false;
		    }
		} else {
		    cloud[i][j] = false;
		}
	    }
	}
    }

    /* M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합 출력 */
    static int sumWater() {
	int sum = 0;
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		sum += basket[i][j];
	    }
	}
	return sum;
    }

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	st = new StringTokenizer(br.readLine());
	// 격자의 크기
	N = init(st.nextToken());
	basket = new int[N][N];
	cloud = new boolean[N][N];
	mcloud = new boolean[N][N];
	// 이동 횟수
	M = init(st.nextToken());
	for (int i = 0; i < N; i++) {
	    st = new StringTokenizer(br.readLine());
	    for (int j = 0; j < N; j++) {
		basket[i][j] = init(st.nextToken());
	    }
	}

	firstCloud();

	for (int i = 0; i < M; i++) {
	    st = new StringTokenizer(br.readLine());
	    int direction = init(st.nextToken());
	    int time = init(st.nextToken());
	    
	    moveCloud(direction, time);
	    
	    copyWater();
	    
	    makeCloud();
	}

	System.out.println(sumWater());

    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}