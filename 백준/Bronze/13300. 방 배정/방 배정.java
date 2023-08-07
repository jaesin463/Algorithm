import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		double[][] student = new double[2][7];
		
		int room = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int MW = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[MW][grade]++;
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 1; j < 7; j++) {
				room += Math.ceil(student[i][j] / k);
			}
		}
		
		System.out.print(room);
	}
}
