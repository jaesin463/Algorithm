import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb;

	Stack<Character> oper = new Stack<>();
	sb = new StringBuilder();

	String str = br.readLine();
	for (int i = 0; i < str.length(); i++) {
	    char temp = str.charAt(i);
	    if (temp >= '0') {
		sb.append(temp);
	    } else if (temp == '+' || temp == '-') {
		while (!oper.isEmpty() && oper.peek() != '(') {
		    sb.append(oper.pop());
		}
		oper.push(temp);
	    } else if (temp == '*' || temp == '/') {
		while (!oper.isEmpty() && (oper.peek() == '*' || oper.peek() =='/') && oper.peek() != '(') {
		    sb.append(oper.pop());
		}
		oper.push(temp);
	    } else if (temp == '(') {
		oper.push(temp);
	    } else if (temp == ')') {
		while (oper.peek() != '(') {
		    sb.append(oper.pop());
		}
		oper.pop();
	    }
	}
	while (!oper.isEmpty()) {
	    sb.append(oper.pop());
	}

	System.out.print(sb.toString());
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}