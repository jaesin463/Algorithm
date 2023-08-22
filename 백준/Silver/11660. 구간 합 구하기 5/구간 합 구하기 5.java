import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = init(st.nextToken());
		int M = init(st.nextToken());

		num = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				num[i][j] = init(st.nextToken()) + temp;
				temp = num[i][j];
			}
		}

		int x1, x2, y1, y2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = init(st.nextToken());
			y1 = init(st.nextToken());
			x2 = init(st.nextToken());
			y2 = init(st.nextToken());
			int sum = 0;
			for(int x = x1; x <= x2; x++) {
				sum += num[x][y2] - num[x][y1 - 1];
			}
			sb.append(sum);
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

}
