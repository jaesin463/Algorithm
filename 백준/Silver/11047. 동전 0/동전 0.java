import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int N = Integer.parseInt(st.nextToken());			
		int money = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		
		for(int i = N - 1; i >= 0; i--) {
			if(coin[i] != 0) {
				cnt += money / coin[i];
				money %= coin[i];
			}
		}
		
		System.out.println(cnt);
		
	}
}
