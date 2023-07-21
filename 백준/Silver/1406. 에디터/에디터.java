import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String first = br.readLine();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < first.length(); i++) {
			left.push(first.charAt(i));
		}

		for (int i = 1; i <= N; i++) {
			String st = br.readLine();

			if (st.charAt(0) == 'L') {
				if (!left.empty())
					right.push(left.pop());
			}

			if (st.charAt(0) == 'D') {
				if (!right.empty())
					left.push(right.pop());
			}

			if (st.charAt(0) == 'B') {
				if (!left.empty())
					left.pop();
			}

			if (st.charAt(0) == 'P') {
				left.push(st.charAt(2));
			}
		}
		
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		StringBuilder sb = new StringBuilder("");
		while (!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}