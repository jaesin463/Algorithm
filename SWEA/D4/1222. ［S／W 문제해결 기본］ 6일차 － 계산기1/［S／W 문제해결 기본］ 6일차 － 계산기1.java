import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	for (int tc = 1; tc <= 10; tc++) {
	    br.readLine();

	    String str = br.readLine();

	    String[] num = str.split("\\+");

	    int sum = 0;
	    for (int i = 0; i < num.length; i++) {
		sum += init(num[i]);
	    }

	    System.out.printf("#%d %d\n", tc, sum);

	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}