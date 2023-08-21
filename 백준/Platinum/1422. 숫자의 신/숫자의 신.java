import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int K = init(st.nextToken());
		int N = init(st.nextToken());
		
		String[] num = new String[K];
		int max = 0;
		for(int i = 0; i < K; i++) {
			num[i] = br.readLine();
			max = Math.max(max, init(num[i]));
		}
		Arrays.sort(num, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));
		
		boolean check = false;
		for(int i = 0; i < K; i++) {
			sb.append(num[i]);
			if(max == init(num[i]) && !check) {
				for(int j = 0; j < N - K; j++) {
					sb.append(num[i]);
				}
				check = true;
			}
		}
			
		System.out.println(sb.toString());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
