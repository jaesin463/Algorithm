import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = init(st.nextToken());
		int M = init(st.nextToken());
		
		int[] lesson = new int[N];
		
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			lesson[i] = init(st.nextToken());
			if(lesson[i] > start) {
				start = lesson[i];
			}
			end += lesson[i];
		}
		
		while(start <= end) {
			int middle = (start + end) /2;
			int sum = 0;
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				if( sum + lesson[i] > middle) {
					count++;
					sum = 0;
				}
				sum += lesson[i];
			}
			if(sum != 0) count++;
			
			if(count > M) start = middle + 1;
			else end = middle - 1;
		}
		
		System.out.println(start);
		
		
		
		

	}
	
	static int init(String str) {
		return Integer.parseInt(str);
	}

}