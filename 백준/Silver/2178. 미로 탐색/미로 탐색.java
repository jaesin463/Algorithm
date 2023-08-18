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
	Queue<int[]> queue = new LinkedList<>();
	// 최초 좌표 큐에 삽입 및 방문 처리
	queue.offer(new int[] { r, c });
	visited[r][c] = true;

	while (!queue.isEmpty()) {
	    //이번에 방문할 노드
	    int[] now = queue.poll();
	    //사방을 탐색
	    for (int i = 0; i < 4; i++) {
		int x = now[0] + dr[i];
		int y = now[1] + dc[i];
		//범위를 벗어 나지 않은 경우
		if (x >= 0 && x < N && y >= 0 && y < M) {
		    //아직 방문하지 않은 좌표이고, 길이 맞는 경우
		    if (!visited[x][y] && miro[x][y] != 0) {
			//방문처리
			visited[x][y] = true;
			//cnt의 역할, 매번 1씩 증가하며 최종 N,M에 숫자가 정해짐
			miro[x][y] = miro[now[0]][now[1]] + 1;
			//좀 있다 (x, y)에 대해서도 사방 탐색해야 되니까 큐에 삽입
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