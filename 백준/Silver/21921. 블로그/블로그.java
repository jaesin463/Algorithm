import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int X, N, arr[];
	static int sum = 0;

	public static void solution() {
		for (int i = 0; i < X; i++)
			sum += arr[i];

		int max = sum;
		int maxCnt = 1;
		for (int i = X; i < N; i++) {
			sum += arr[i] - arr[i - X];
			if (max == sum)
				maxCnt++;
			else if (max < sum) {
				max = sum;
				maxCnt = 1;
			}
		}

		System.out.println(max == 0 ? "SAD" : max + "\n" + maxCnt);
	}

	public static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = init(st);
		X = init(st);

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = init(st);
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	public static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	public static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

}