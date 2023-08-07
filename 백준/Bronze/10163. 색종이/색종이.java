import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nPaper = Integer.parseInt(br.readLine());

		int[][] paper = new int[1001][1001];

		int[] result = new int[nPaper + 1];

		for (int i = 1; i <= nPaper; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Xa = Integer.parseInt(st.nextToken());
			int Ya = Integer.parseInt(st.nextToken());
			int Xb = Integer.parseInt(st.nextToken());
			int Yb = Integer.parseInt(st.nextToken());
			for (int x = Xa; x < Xa + Xb; x++) {
				for (int y = Ya; y < Ya + Yb; y++) {
					if (paper[x][y] != 0) {
						result[paper[x][y]]--;
					}
					paper[x][y] = i;
					result[i]++;
				}
			}
		}

		for (int i = 1; i <= nPaper; i++) {
			System.out.println(result[i]);
		}
	}
}
