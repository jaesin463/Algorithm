import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int row, col, n, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int dx = now[0] + dr[i];
				int dy = now[1] + dc[i];
				
				if(dx >= 0 && dx < row && dy >= 0 && dy < col) {
					if(!visited[dx][dy] && map[dx][dy] == 1) {
						q.add(new int[] {dx, dy});
						visited[dx][dy] = true;
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = init(br.readLine());
		
		for(int tc = 0; tc < test_case; tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			col = init(st.nextToken());
			row = init(st.nextToken());
			map = new int[row][col];
			visited = new boolean[row][col];
			
			n = init(st.nextToken());
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int y = init(st.nextToken());
				int x = init(st.nextToken());
				map[x][y] = 1;
			}
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col;j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						BFS(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}

	}
	
	static int init(String str) {
		return Integer.parseInt(str);
	}

}