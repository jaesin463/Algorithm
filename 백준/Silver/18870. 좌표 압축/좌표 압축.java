import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = init(br.readLine());
		int[] num = new int[N];
		int[] sort = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int temp = init(st.nextToken()); 
			num[i] = temp;
			sort[i] = temp;
		}
		
		Arrays.sort(sort);
		
		HashMap<Integer, Integer> priority = new HashMap<Integer, Integer>();
		int idx = 0;
		for(int i = 0; i < N; i++) {
			priority.put(sort[i], priority.getOrDefault(sort[i], idx));
			if(priority.get(sort[i]) == idx) idx++;
		}
		
		for(int i = 0; i< N; i++) {
			num[i] = priority.get(num[i]);
			sb.append(num[i] + " ");
		}
		
		System.out.println(sb.toString());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
