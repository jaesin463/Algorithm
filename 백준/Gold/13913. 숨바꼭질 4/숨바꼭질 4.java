import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static int[] hide = new int[100001];
	static int[] route = new int[100001];

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		hide[N] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == K) {
				return;
			}
			if (2 * now < 100001 && (hide[2 * now] == 0 || hide[2 * now] == hide[now] + 1)) {
				q.add(2 * now);
				hide[2 * now] = hide[now] + 1;
				route[2 * now] = now;
			}
			if (now > 0 && (hide[now - 1] == 0 || hide[now - 1] == hide[now] + 1)) {
				q.add(now - 1);
				hide[now - 1] = hide[now] + 1;
				route[now - 1] = now;
			}
			if (now < 100000 && (hide[now + 1] == 0 || hide[now + 1] == hide[now] + 1)) {
				q.add(now + 1);
				hide[now + 1] = hide[now] + 1;
				route[now + 1] = now;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = init(st.nextToken());
		K = init(st.nextToken());
		BFS();
		
		Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(route[index]);
            index = route[index];
        }
        
		System.out.println(hide[K] - 1);
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb.toString());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
