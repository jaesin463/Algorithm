import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int weight[];

	static void solution() {
		Arrays.sort(weight);

		if(weight[0] != 1) {
			System.out.println(1);
			return;
		}
				
		// 누적합
		int sum = weight[0];
		for (int i = 1; i < N; i++) {
			if (weight[i] != weight[i-1] + 1 && sum + 1 < weight[i]) {
				System.out.println(sum + 1);
				return;
			}
			sum += weight[i];
		}
		
		System.out.println(sum + 1);
	}

	static void make() throws IOException {
		N = init();
		weight = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			weight[i] = init(st);
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}