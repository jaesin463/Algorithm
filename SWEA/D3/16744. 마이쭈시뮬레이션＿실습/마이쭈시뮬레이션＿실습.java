import java.util.*;
import java.io.*;

public class Solution {
    public static int[][] map;
    public static boolean[][] check;
    public static int[] start;
    public static int[] dr = { -1, 0, 1, 0 };
    public static int[] dc = { 0, 1, 0, -1 };
    public static int result;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	int test_case = init(br.readLine());
	
	for (int tc = 1; tc <= test_case; tc++) {
	    Queue<int[]> queue = new LinkedList<>();

	    int N = init(br.readLine());
	    int idx = 1;
	    
	    queue.offer(new int[] {idx++, 1});
	    while(N > 0) {
		int[] now = queue.poll();
		N -= now[1];
		if(N <= 0) System.out.printf("#%d %d\n", tc, now[0]);
		else {
		    now[1]++;
		    queue.offer(now);
		    queue.offer(new int[] {idx++, 1});
		}
	    }
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}