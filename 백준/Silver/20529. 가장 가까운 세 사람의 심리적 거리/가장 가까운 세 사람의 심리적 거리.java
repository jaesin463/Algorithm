import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class Main {
	static int N;
	static int minDis;
	
	public static void close(String[] mbti) {
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					int dis = 0;
					for(int l = 0; l < 4; l++) {
						if(mbti[i].charAt(l) != mbti[j].charAt(l)) {
							dis++;
						}
						if(mbti[j].charAt(l) != mbti[k].charAt(l)) {
							dis++;
						}
						if(mbti[k].charAt(l) != mbti[i].charAt(l)) {
							dis++;
						}
					}
					minDis = Math.min(dis, minDis);
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		String[] mbti;

		for (int tc = 1; tc <= test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			mbti = br.readLine().split(" ");
			if(N > 32) {
				System.out.println(0);
				continue;
			}
			minDis = Integer.MAX_VALUE;
			close(mbti);
			System.out.println(minDis);
		}
	}
}
