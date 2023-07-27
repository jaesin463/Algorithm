import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		// 입력 값 할당
		int N = Integer.parseInt(br.readLine());
		
		// N개의 요소를 가진 배열 생성
		int[][] num = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num, (a, b) -> {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(num[i][0] + " " + num[i][1]);
		}
	}
}
