import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = init(br.readLine());
		int[] test = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			test[i] = init(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int total = init(st.nextToken());
		int boo = init(st.nextToken());

		long sum = 0;
		for (int i = 0; i < N; i++) {
			test[i] -= total;
			sum++;
			if(test[i] > 0)
				sum = sum + (test[i] % boo == 0 ? test[i] / boo : test[i] / boo + 1);
		}
		
		System.out.println(sum);

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
