import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//	int test_case = init(br.readLine());

	test : for (int tc = 1; tc <= 10; tc++) {
	    br.readLine();
	    
	    String want = br.readLine();
	    
	    String str = br.readLine();
	    
	    int cnt =0;
	    
	    while(str.contains(want)) {
		int idx = str.indexOf(want);
		str = str.substring(0, idx) + str.substring(idx + want.length());
		cnt++;
	    }
	    
	    System.out.printf("#%d %d\n", tc, cnt);
	}
    }

    public static int init(String str) {
	return Integer.parseInt(str);
    }
}
