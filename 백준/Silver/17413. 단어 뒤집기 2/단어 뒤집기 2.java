import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<String> s = new Stack<String>();

	public static void rWord() {
		while (!s.empty()) {
			sb.append(s.pop());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] wordArr = br.readLine().split("");
		String word;
		int where = 5;
		int idx = 0;
		// StringTokenizer의 남은 토큰이 0일 때까지
		while (idx < wordArr.length) {
			// 다음 토큰
			word = wordArr[idx];

			if (word.equals("<"))
				where = 1;
			else if (word.equals(">"))
				where = 2;
			else if (idx == wordArr.length - 1)
				where = 4;
			else if (word.equals(" "))
				if (where != 1)	where = 3;

			switch (where) {
			case 1:
				rWord();
				sb.append(word);
				break;
			case 2:
				sb.append(word);
				where = 5;
				break;
			case 3:
				rWord();
				sb.append(word);
				where = 5;
				break;
			case 4:
				sb.append(word);
				rWord();
				break;
			case 5:
				s.push(word);
				break;
			}
			idx++;
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}
}
