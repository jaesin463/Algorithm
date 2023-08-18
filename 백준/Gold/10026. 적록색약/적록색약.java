import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 사방 탐색
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    // 방문 여부 및 지도 배열
    static int N;
    static boolean[][] visited;
    // 단지 수
    static int cnt;
    // 색약 유무 별 구역의 수
    static int[] area = new int[2];

    static Queue<int[]> q = new LinkedList<>();

    static void BFS(char[][] paint, int r, int c, int nArea) {
	q.add(new int[] { r, c });
	visited[r][c] = true;

	while (!q.isEmpty()) {
	    int[] now = q.poll();
	    for (int i = 0; i < 4; i++) {
		int x = now[0] + dr[i];
		int y = now[1] + dc[i];

		if (x >= 0 && x < N && y >= 0 && y < N) {
		    if (!visited[x][y] && paint[x][y] == paint[r][c]) {
			q.add(new int[] { x, y });
			visited[x][y] = true;
		    }
		}
	    }
	}

	area[nArea]++;
    }

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	N = init(br.readLine());
	char[][] paint1 = new char[N][N];
	char[][] paint2 = new char[N][N];

	for (int i = 0; i < N; i++) {
	    String str = br.readLine();
	    for (int j = 0; j < N; j++) {
		paint1[i][j] = str.charAt(j);
		paint2[i][j] = paint1[i][j];
		if(paint2[i][j] == 'R') {
		    paint2[i][j] = 'G';
		}
	    }
	}
	// 적록색약 X
	visited = new boolean[N][N];
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		if (!visited[i][j]) {
		    BFS(paint1, i, j, 0);
		}
	    }
	}
	// 적록색약 O
	visited = new boolean[N][N];
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		if (!visited[i][j]) {
		    BFS(paint2, i, j, 1);
		}
	    }
	}

	System.out.println(area[0] + " " + area[1]);

    }

    static int init(String str) {
	return Integer.parseInt(str);
    }

    static int init(char c) {
	return c - '0';
    }
}
