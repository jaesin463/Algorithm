import java.util.*;
import java.io.*;

public class Solution {
    public static int[][] map;
    public static boolean[][] check;
    public static int[] start;
    public static int[] dr = { -1, 0, 1, 0 };
    public static int[] dc = { 0, 1, 0, -1 };
    public static int result;

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	for (int tc = 1; tc <= 10; tc++) {
	    br.readLine();
	    
	    map = new int[16][16];
	    check = new boolean[16][16];
	    result = 0;
	    
	    for (int i = 0; i < 16; i++) {
		String str = br.readLine();
		for (int j = 0; j < 16; j++) {
		    map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
		    if (map[i][j] == 2)
			start = new int[]{i, j};
		}
	    }
	    check[start[0]][start[1]] = true;
	    dfs(start[0], start[1]);
	    
	    System.out.printf("#%d %d\n", tc, result);
	}
    }

    static void dfs(int row, int col) {
	for (int i = 0; i < dr.length; i++) {
	    int nr = row + dr[i];
	    int nc = col + dc[i];

	    if (nr >= 16 || nr < 0 || nc >= 16 || nc < 0)
		continue;

	    if (check[nr][nc])
		continue;

	    if (map[nr][nc] == 1)
		continue;

	    if (map[nr][nc] == 3) {
		result = 1;
		return;
	    }
	    
	    check[nr][nc] = true;
	    dfs(nr, nc);
	}
    }
    
    static int init(String str) {
	return Integer.parseInt(str);
    }
}