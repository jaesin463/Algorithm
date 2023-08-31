import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] num;

	static void solution() {
		for (int i = 0; i < N - 1; i++) {
			boolean flag = false;
			if (num[i] + 1 == num[i + 1]) {
				for (int j = i + 2; j < N; j++) {
					if (num[i + 1] != num[j]) {
						flag = true;
						swap(i + 1, j);
						break;
					}
				}

				if (!flag) {
					int tmp = 0;
					for (int k = i - 1; k >= 0; k--) {
						if (num[k] != num[i]) {
							tmp = k + 1;
							break;
						}
					}
					swap(tmp, i + 1);
				}
			}
		}
	}

	static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	static void make() throws IOException {
		N = init(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = init(st.nextToken());
		}
		Arrays.sort(num);
	}

	static void end() {
		for (int i = 0; i < N; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
		end();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}