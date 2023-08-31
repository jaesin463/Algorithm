import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] str1;
	static char[] str2;
	static int[][] dp;

	static void LCS() {
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] != str2[j - 1])
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				else
					dp[i][j] = dp[i - 1][j - 1] + 1;
			}
		}
	}

	static void root() {
		int len1 = str1.length;
		int len2 = str2.length;
		Stack<Character> stack = new Stack<>();
		while (len1 >= 1 && len2 >= 1) {
			if (dp[len1][len2] == dp[len1 - 1][len2])
				len1--;
			else if (dp[len1][len2] == dp[len1][len2 - 1])
				len2--;
			else {
				stack.push(str1[len1 - 1]);
				len1--;
				len2--;
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	public static void main(String[] args) throws IOException {
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		dp = new int[str1.length + 1][str2.length + 1];
		LCS();
		System.out.println(dp[str1.length][str2.length]);
		root();

	}

}