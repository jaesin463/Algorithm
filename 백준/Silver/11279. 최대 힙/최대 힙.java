import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(maxHeap.size() == 0) {
					sb.append("0").append("\n");
				} else {
					sb.append(maxHeap.poll()).append("\n");
				}
			} else {
				maxHeap.add(x);
			}
		}
		System.out.println(sb.toString());
	}
}