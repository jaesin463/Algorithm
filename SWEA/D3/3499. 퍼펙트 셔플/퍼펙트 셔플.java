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
	    int N = init(br.readLine());
	    Queue<String> queue1 = new LinkedList<String>();
	    Queue<String> queue2 = new LinkedList<String>();
	    
	    st = new StringTokenizer(br.readLine());
	    
	    int mid = 0;
	    if(N % 2 == 1) {
		mid = N/2 + 1;
	    } else {
		mid = N / 2;
	    }
	    
	    for(int i = 0; i < mid; i++) {
		queue1.offer(st.nextToken());
	    }
	    for(int i = mid; i < N; i++) {
		queue2.offer(st.nextToken());
	    }
	    
	    String result = "";
	    
	    for(int i = 0; i < N/2 + 1; i++) {
		if(!queue1.isEmpty())
		    result += queue1.poll() + " ";
		if(!queue2.isEmpty())
		    result += queue2.poll() + " ";
	    }

	    System.out.printf("#%d %s\n", tc, result);
	}
    }
    
    static int init(String str) {
	return Integer.parseInt(str);
    }
}