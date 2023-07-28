
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<int[]> deque = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int[] num = { i + 1, Integer.parseInt(st.nextToken()) };
			deque.add(num);
		}

		

		while (deque.size() > 1) {
			int[] time = deque.pollFirst();
			System.out.print(time[0] + " ");
			if (time[1] > 0) {

				for (int j = 1; j < time[1]; j++) {
					deque.offerLast(deque.pollFirst());
				}

			} else if (time[1] < 0) {

				for (int j = time[1]; j < 0; j++) {
					deque.offerFirst(deque.pollLast());
				}

			}
		}
		System.out.println(deque.poll()[0]);

	}
}