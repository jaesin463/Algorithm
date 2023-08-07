import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= test_case; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			for(int j = 0;j < N;j++) {
				arr[j][0] = 1;
				arr[j][j] = 1;
				for(int k = 1; k < j; k++) {
					arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
				}
			}
			
			System.out.printf("#%d\n", i);
			for(int j = 0; j < N;j++) {
				for(int k = 0; k <= j; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println();
			}
		}
		
	}
}
