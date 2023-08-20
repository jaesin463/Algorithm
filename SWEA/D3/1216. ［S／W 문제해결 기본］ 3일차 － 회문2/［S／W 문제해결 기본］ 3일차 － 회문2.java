import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//	int test_case = init(br.readLine());

	for (int tc = 1; tc <= 10; tc++) {
	    br.readLine();
	    char[][] palin = new char[100][];

	    for (int i = 0; i < 100; i++) {
		palin[i] = br.readLine().toCharArray();
	    }

	    int maxlen = Integer.MIN_VALUE;

	    // row
	    for (int i = 0; i < 100; i++) {
		// col
		for (int j = 0; j < 100; j++) {
		    // 뒤에서 부터 1씩 감소
		    loop1: for (int k = 99; k >= j; k--) {
			// 두 포인터가 만날 때 까지
			for (int l = 0; j + l <= (j + k) / 2; l++) {
			    if (palin[i][j + l] != palin[i][k - l]) {
				continue loop1;
			    }
			}
			maxlen = Math.max(maxlen, k - j + 1);
		    }
		    loop2: for (int k = 99; k >= i; k--) {
			// 두 포인터가 만날 때 까지
			for (int l = 0; i + l <= (i + k) / 2; l++) {
			    if (palin[i + l][j] != palin[k - l][j]) {
				continue loop2;
			    }
			}
			maxlen = Math.max(maxlen, k - i + 1);
		    }

		}
	    }
	    System.out.printf("#%d %d\n", tc, maxlen);
	}
    }

//    public static int init(String str) {
//	return Integer.parseInt(str);
//    }
}
