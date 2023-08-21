import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] choice;
	
	static void recur(int depth, int cnt) {
		if(depth == N) {
			if(cnt == M) {
				for(int i = 0 ; i < N; i++) {
					if(choice[i]) System.out.print((i + 1) + " ");
				}
				System.out.println();
			}
			return;
		}
		if(cnt > M) return;
		
		choice[depth] = true;
		recur(depth + 1, cnt + 1);
		choice[depth] = false;
		recur(depth + 1, cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = init(st.nextToken());
		M = init(st.nextToken());
		
		choice = new boolean[N];
		recur(0, 0);
		
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

}
