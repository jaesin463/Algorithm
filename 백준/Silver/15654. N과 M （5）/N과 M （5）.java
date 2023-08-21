import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] choice;
	static int[] num;
	static int[] arr;

	static void recur(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!choice[i]) {
				choice[i] = true;
				arr[cnt] = num[i];
				recur(cnt + 1);
				choice[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = init(st.nextToken());
		M = init(st.nextToken());
		
		arr = new int[N];
		num = new int[N];
		choice = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = init(st.nextToken());
		}
		Arrays.sort(num);
		recur(0);

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

}
