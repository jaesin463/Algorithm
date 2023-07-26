import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[][] apt = new int[15][15];
	
	public static void residentsApt() {
				
		for(int i = 0; i < 15; i++) {
			apt[i][1] = 1;
			apt[0][i] = i;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 2; j < 15; j++) {
				apt[i][j] = apt[i-1][j] + apt[i][j-1];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		residentsApt();
		
		int test_case = Integer.parseInt(br.readLine());
		for(int i = 0; i < test_case; i++) {
			System.out.println(apt[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())]);
		}
		
	}
}