import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int round = Integer.parseInt(br.readLine());
		char[] result = new char[round];

		for (int i = 0; i < round; i++) {

			int[][] child = new int[2][5];

			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				while (st.countTokens() != 0) {
					child[j][Integer.parseInt(st.nextToken())]++;
				}
			}
			
			if(child[0][4] != child[1][4]) {
				if(child[0][4] > child[1][4]) {
					result[i] = 'A';
				} else result[i] = 'B';
			} else if(child[0][3] != child[1][3]) {
				if(child[0][3] > child[1][3]) {
					result[i] = 'A';
				} else result[i] = 'B';
			} else if(child[0][2] != child[1][2]) {
				if(child[0][2] > child[1][2]) {
					result[i] = 'A';
				} else result[i] = 'B';
			} else if(child[0][1] != child[1][1]) {
				if(child[0][1] > child[1][1]) {
					result[i] = 'A';
				} else result[i] = 'B';
			} else result[i] = 'D';
			
			System.out.println(result[i]);
		}

	}
}
