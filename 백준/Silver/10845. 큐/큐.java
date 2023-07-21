import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		Queue<Integer> q = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		int last = 1;
		String str;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			if (temp.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				q.add(last);
			}

			if (temp.equals("pop")) {
				if(q.size() == 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.poll());
				}
			}

			if (temp.equals("size")) {
				System.out.println(q.size());
			}

			if (temp.equals("empty")) {
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			
			if (temp.equals("front")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
			}
			
			if (temp.equals("back")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(last);
			}

		}

	}
}