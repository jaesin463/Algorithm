import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb;

	for (int tc = 1; tc <= 10; tc++) {
	    Stack<Character> oper = new Stack<>();
	    Stack<Integer> stack = new Stack<>();
	    sb = new StringBuilder();
	    br.readLine();
	    int result = 0;
	    int temp1, temp2;

	    String str = br.readLine();
	    for (int i = 0; i < str.length(); i++) {
		char temp = str.charAt(i);
		if (temp >= '0') {
		    sb.append(temp);
		} else if (temp == '+') {
		    while (!oper.isEmpty()) {
			sb.append(oper.pop());
		    }
		    oper.push(temp);
		} else if (temp == '*') {
		    while (!oper.isEmpty() && oper.peek() == '*') {
			sb.append(oper.pop());
		    }
		    oper.push(temp);
		}
	    }
	    while (!oper.isEmpty()) {
		sb.append(oper.pop());
	    }
	    char[] ch = sb.toString().toCharArray();

	    for (int i = 0; i < ch.length; i++) {
		if (ch[i] >= '0') {
		    stack.push(ch[i] - '0');
		} else {
		    char operator = ch[i];
		    switch (operator) {
		    case '+':
			temp1 = stack.pop();
			temp2 = stack.pop();
			result = temp2 + temp1;
			stack.push(result);
			break;
		    case '*':
			temp1 = stack.pop();
			temp2 = stack.pop();
			result = temp2 * temp1;
			stack.push(result);
			break;
		    }
		}
	    }

	    System.out.printf("#%d %d\n", tc, result);
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}