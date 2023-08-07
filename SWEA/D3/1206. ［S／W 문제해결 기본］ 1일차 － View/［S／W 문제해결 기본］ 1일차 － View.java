import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {

			int cnt = 0;

			int N = Integer.parseInt(br.readLine());
			int[] view = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				view[j] = Integer.parseInt(st.nextToken());
			}

			int max = Integer.MIN_VALUE;
			
			for (int j = 0; j < N; j++) {
				if (j == 0 && view[j] > view[j + 1] && view[j] > view[j + 2]) {
					max = Math.max(view[j+1], view[j+2]);
					cnt += (view[j] - max);
				} else if (j == 1 && view[j] > view[j - 1] && view[j] > view[j + 1] && view[j] > view[j + 2]) {
					max = Math.max(Math.max(view[j+1], view[j+2]), view[j-1]);
					cnt += (view[j] - max);
				} else if (j == N - 2 && view[j] > view[j - 2] && view[j] > view[j - 1] && view[j] > view[j + 1]) {
					max = Math.max(Math.max(view[j-1], view[j-2]), view[j+1]);
					cnt += (view[j] - max);
				} else if (j == N - 1 && view[j] > view[j - 1] && view[j] > view[j - 2]) {
					max = Math.max(view[j-1], view[j-2]);
					cnt += (view[j] - max);
				} else if (j > 1 && j < N - 2 && view[j] > view[j - 1] && view[j] > view[j + 1] && view[j] > view[j - 2]
						&& view[j] > view[j + 2]) {
					max = Math.max(Math.max(Math.max(view[j-1], view[j-2]), view[j+1]), view[j+2]);
					cnt += (view[j] - max);
				}
			}

			System.out.printf("#%d %d\n", i + 1, cnt);
		}

	}
}
