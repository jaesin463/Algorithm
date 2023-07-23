import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder result = new StringBuilder("<");
		Queue<Integer> q = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int idx = 0;

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(q.size() != 1) {
			for(int i = 1; i <= K - 1; i++) {
				q.offer(q.poll());
			}
			result.append(q.poll()).append(", ");
		}

		result.append(q.poll()).append(">");
		bw.write(result.toString());
		br.close();
		bw.flush();
		bw.close();

	}
}