import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int test_case = init(br.readLine());

	test : for (int tc = 1; tc <= test_case; tc++) {
	    String str = br.readLine();

	    for (int i = 0; i < str.length() / 2; i++) {
		if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
		    System.out.printf("#%d %d\n", tc, 0);
		    continue test;
		}
	    }
	    
	    System.out.printf("#%d %d\n", tc, 1);
	}
    }

    public static int init(String str) {
	return Integer.parseInt(str);
    }
}
