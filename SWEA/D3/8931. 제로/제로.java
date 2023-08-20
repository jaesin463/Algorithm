import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int test_case = init(br.readLine());

	for (int tc = 1; tc <= test_case; tc++) {
	    Stack<Integer> stack = new Stack<>();

	    int time = init(br.readLine());

	    for (int i = 0; i < time; i++) {
		int temp = init(br.readLine());
		
		if (temp == 0) {
		    stack.pop();
		} else {
		    stack.push(temp);
		}
	    }
	    int sum = 0;
	    while(!stack.isEmpty()) {
		sum += stack.pop();
	    }

	    System.out.printf("#%d %d\n", tc, sum);

	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}