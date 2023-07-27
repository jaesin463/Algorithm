import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();

		while (true) {
			st.clear();
			boolean tf = true;
			// 문장 값 할당
			String str = br.readLine();

			if (str.equals("."))
				break;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					st.push(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					try {
						if (st.pop() != '(') {
							tf = false;
							break;
						}
					} catch (EmptyStackException e) {
						tf = false;
						break;
					}
				} else if (str.charAt(i) == ']') {
					try {
						if (st.pop() != '[') {
							tf = false;
							break;
						}
					} catch (EmptyStackException e) {
						tf = false;
						break;
					}
				}
			}
			if(st.isEmpty() && tf) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
