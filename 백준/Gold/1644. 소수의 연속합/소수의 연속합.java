import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, S;
	static int cnt = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] isprime;

	static int solution() {
		int cnt = 0;
		if (N == 2) {
			return 1;
		}

		int left = 0;
		int sum = 0;

		for (int right = 0; right < list.size(); right++) {
			sum += list.get(right);
			if (sum == N)
				cnt++;
			while (sum >= N) {
				sum -= list.get(left);
				if (sum == N)
					cnt++;
				left++;
			}
		}

		return cnt;
	}

	static void make() throws IOException {
		N = init(br.readLine());
		isprime = new boolean[N + 1];
		isprime[0] = isprime[1] = true;

		for (int i = 2; i * i <= N; i++) {
			if (!isprime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isprime[j] = true;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (!isprime[i])
				list.add(i);
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		System.out.println(solution());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}