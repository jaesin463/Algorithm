import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] friends = new int[N];
		
		int idx = 0;
		int cnt = 0;
		
		while(friends[idx]+1 != M) {
			friends[idx]++;
			if(friends[idx] % 2 == 1) {
				idx += L;
				if(idx >= N) idx -= N;
			} else {
				idx -= L;
				if(idx < 0) idx += N;
			}
			cnt++;
		}
		
		System.out.println(cnt);

	}
}
