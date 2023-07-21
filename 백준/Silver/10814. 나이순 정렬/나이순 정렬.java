import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nHuman = Integer.parseInt(br.readLine());

		String[][] per = new String[nHuman][2];

		// per로 이루어진 2차원 배열 생성
		for (int i = 0; i < nHuman; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				per[i][j] = st.nextToken();
			}
		}

		Arrays.sort(per, (per1,per2) ->{
			if(per1[0].equals(per2[0])) {
				return 0;
			}else {
				return Integer.parseInt(per1[0]) - Integer.parseInt(per2[0]);
			}
		});
		
		for(int i = 0; i < nHuman; i++) {
			System.out.println(per[i][0] + " " + per[i][1]);
		}
		
		
	}
}