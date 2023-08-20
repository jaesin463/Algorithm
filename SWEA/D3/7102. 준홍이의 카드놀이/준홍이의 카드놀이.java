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
	    Queue<Integer> queue1 = new LinkedList<>();
	    Queue<Integer> queue2 = new LinkedList<>();

	    st = new StringTokenizer(br.readLine());
	    int N = init(st.nextToken());
	    int M = init(st.nextToken());

	    int[] count = new int[N + M + 1];
	    
	    for(int i = 1; i <= N; i++) {
		queue1.offer(i);
	    }
	    for(int i = 1; i <= M; i++) {
		queue2.offer(i);
	    }
	    
	    for(int i = 0; i < N; i++) {
		int n1 = queue1.poll();
		for(int j = 0; j < M; j++) {
		    int m1 = queue2.poll();
		    count[n1 + m1]++;
		    queue2.offer(m1);
		}
		queue1.offer(n1);
	    }
	    
	    int max = 0;
	    for(int i = 0; i < count.length; i++) {
		max = Math.max(max, count[i]);
	    }
	    String result = "";
	    for(int i = 0; i < count.length; i++) {
		if(count[i] == max) {
		    result += i + " ";
		}
	    }

	    System.out.printf("#%d %s\n", tc, result);
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}