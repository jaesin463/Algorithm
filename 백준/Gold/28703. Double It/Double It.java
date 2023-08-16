import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

	N = init(br.readLine()); // 배열의 길이 입력
	StringTokenizer st = new StringTokenizer(br.readLine());
	for (int i = 0; i < N; i++) {
	    int num = init(st.nextToken());
	    minHeap.offer(num);
	    maxHeap.offer(num);
	}

	System.out.println(min(minHeap, maxHeap));
    }

    public static int min(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
	int max = maxHeap.peek();
	//1. 입력 값의 최댓값 최솟값 차이를 답의 후보
	int minDiff = Math.abs(maxHeap.peek() - minHeap.peek());
	while(minHeap.peek() != max) {
	    int min = 2 * minHeap.poll();
	    
	    minHeap.offer(min);
	    maxHeap.offer(min);
	    
	    int diff = Math.abs(maxHeap.peek() - minHeap.peek());
	    minDiff = Math.min(minDiff, diff);
	}
	
	return minDiff;
    }

    public static int init(String str) {
	return Integer.parseInt(str);
    }

}