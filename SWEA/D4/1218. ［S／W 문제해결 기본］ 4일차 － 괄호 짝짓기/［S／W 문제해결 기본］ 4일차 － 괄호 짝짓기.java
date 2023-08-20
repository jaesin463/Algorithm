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
	    char[] gualho = br.readLine().toCharArray();
	    Stack<Character> stack = new Stack<>();
	    boolean check = true;

	    for (int i = 0; i < gualho.length; i++) {
		char temp = gualho[i];
		if (temp == ']') {
		    if (stack.peek() == '[') {
			stack.pop();
		    } else {
			check = false;
			break;
		    }
		} else if (temp == '>') {
		    if (stack.peek() == '<') {
			stack.pop();
		    } else {
			check = false;
			break;
		    }
		} else if (temp == ')') {
		    if (stack.peek() == '(') {
			stack.pop();
		    } else {
			check = false;
			break;
		    }
		} else if (temp == '}') {
		    if (stack.peek() == '{') {
			stack.pop();
		    } else {
			check = false;
			break;
		    }
		} else {
		    stack.push(temp);
		}
	    }
	    System.out.printf("#%d %d\n", tc, check ? 1 : 0);

	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}