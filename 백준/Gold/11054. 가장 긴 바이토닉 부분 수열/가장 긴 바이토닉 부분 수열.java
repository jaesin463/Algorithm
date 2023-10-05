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
	static int N;
	static int max = 0;
	static int[] num;
	static int[] leftDp;
	static int[] rightDp;

	static void left() {
		leftDp[0] = 1;
		for (int i = 1; i < N; i++) {
			leftDp[i] = 1;
			for (int l = 0; l < i; l++) {
				if (num[i] > num[l] && leftDp[l] + 1 > leftDp[i]) {
					leftDp[i] = leftDp[l] + 1;
				}
			}
		}
	}

	static void right() {
		rightDp[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			rightDp[i] = 1;
			for (int r = N - 1; r > i; r--) {
				if (num[i] > num[r] && rightDp[r] + 1 > rightDp[i]) {
					rightDp[i] = rightDp[r] + 1;
				}
			}
		}
	}

	static void solution() {
		left();
		right();

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, leftDp[i] + rightDp[i] - 1);
		}

		System.out.println(result);
	}

	static void make() throws IOException {
		N = init();

		num = new int[N];
		leftDp = new int[N];
		rightDp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = init(st);
			max = Math.max(max, num[i]);
		}
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
