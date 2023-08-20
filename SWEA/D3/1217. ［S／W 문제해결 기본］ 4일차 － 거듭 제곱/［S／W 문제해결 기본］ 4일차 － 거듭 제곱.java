import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static int num;
    static int result;
    
    static void recur(int depth, int cnt) {
	if(depth == cnt) {
	    return;
	}
	result *= num;
	recur(depth + 1, cnt);
	return;
    }
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	for (int tc = 1; tc <= 10; tc++) {
	    br.readLine();
	    result = 1;
	    st = new StringTokenizer(br.readLine());
	    
	    num = init(st.nextToken());
	    int N = init(st.nextToken());
	    recur(0, N);
	    
	    System.out.printf("#%d %d\n", tc, result);
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}