import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int round = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<round;i++) {
			String winner = "D";
			int[] Acard = new int[4]; // 네모0 세모1 동그라미2 별3
			int[] Bcard = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Anum = Integer.parseInt(st.nextToken());
			for(int n = 0;n<Anum;n++) {
				Acard[Integer.parseInt(st.nextToken())-1]++;
			}
			st = new StringTokenizer(br.readLine());
			int Bnum = Integer.parseInt(st.nextToken());
			for(int n = 0;n<Bnum;n++) {
				Bcard[Integer.parseInt(st.nextToken())-1]++;
			}
			for(int j = 3;j>=0;j--) {
				if(Acard[j]>Bcard[j]) {
					winner = "A";
					break;
				} else if(Acard[j]<Bcard[j]) {
					winner = "B";
					break;
				}
			}
			sb.append(winner).append("\n");
		}
		System.out.println(sb);
	}
}