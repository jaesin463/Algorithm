import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, S;
	static int result = Integer.MAX_VALUE;
	static int[] num;

	static void solution() {
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while(start < N && end < N) {
			sum += num[end++];
			if(sum >= S) {
				while(sum >= S) {
					sum -= num[start++];
				}
				result = Math.min(result, end - start + 1);
			}
		}
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		S = init(st.nextToken());

		num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = init(st.nextToken());
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}