import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = init(br.readLine());
		int[][] meet = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meet[i][0] = init(st.nextToken());
			meet[i][1] = init(st.nextToken());
		}

		Arrays.sort(meet, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else {
				return o1[1] - o2[1];
			}
		});

		int now = Integer.MIN_VALUE;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(meet[i][0] >= now) {
				now = meet[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}