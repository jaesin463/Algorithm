import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static boolean[][] visited;
    static int[][] miro;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	st = new StringTokenizer(br.readLine());

	N = init(st.nextToken());
	M = init(st.nextToken());

	miro = new int[N][M];
	visited = new boolean[N][M];

	for (int i = 0; i < N; i++) {
	    String str = br.readLine();
	    for (int j = 0; j < M; j++) {
		miro[i][j] = init(str.charAt(j));
	    }
	}

	BFS(0, 0);
	System.out.println(miro[N - 1][M - 1]);
    }

    static void BFS(int r, int c) {
	// BFS는 큐로 구현
	Queue<int[]> queue = new LinkedList<>();
	// 지금 방문 중인 노드 추가
	queue.offer(new int[] { r, c });
	// 방문 처리
	visited[r][c] = true;

	while (!queue.isEmpty()) {
	    // 제일 앞에 있는 노드
	    int[] now = queue.poll();
	    // 연결 된 노드들을 큐에 추가
	    for (int i = 0; i < 4; i++) {
		int x = now[0] + dr[i];
		int y = now[1] + dc[i];

		if (x >= 0 && x < N && y >= 0 && y < M) {
		    if (!visited[x][y] && miro[x][y] != 0) {
			visited[x][y] = true;
			miro[x][y] = miro[now[0]][now[1]] + 1;
			queue.offer(new int[] { x, y });
		    }
		}
	    }

	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }

    static int init(char c) {
	return c - '0';
    }
}