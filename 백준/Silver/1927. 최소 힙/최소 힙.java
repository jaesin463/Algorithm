import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		int nInput = Integer.parseInt(br.readLine());
		int input = 0;

		for(int i = 0; i < nInput; i++) {
			input = Integer.parseInt(br.readLine());

			if(input == 0) {
				System.out.println(minHeap.isEmpty() ? 0 : minHeap.poll());
			}
			else {
				minHeap.offer(input);
			}
		}

	}

}