import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {    
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    	
    	int N = init(br.readLine());
    	
    	int[] num = new int[N*N];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N;j++) {
    			maxHeap.offer(init(st.nextToken()));
    		}
    	}
    	
    	int result = 0;
    	for(int i = 0; i < N; i++) {
    		result = maxHeap.poll();
    	}
    	
    	System.out.print(result);
    	
    }
    
    public static int init(String str) {
    	return Integer.parseInt(str);
    }
}
