import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		double N = Integer.parseInt(br.readLine());
		int cnt=0;
		
		for(int i = 1; i <= Math.sqrt(N); i++) {
			for(int j = i; j <= N; j++) {
				if(i * j <= N) {
					cnt++;
				} else {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
