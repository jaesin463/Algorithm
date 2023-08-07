import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> atm = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			atm.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		int front = 0;
		
		for(int i = 0; i < N; i++) {
			int temp = atm.poll();
			front += temp;
			sum += front;
		}
		
		System.out.println(sum);

	}
}
