import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= test_case; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];
			
			
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < N; k++) {
					int temp = Integer.parseInt(st.nextToken());
					arr[j][k] = temp;
					arr90[k][N-1-j] = temp;
					arr180[N-1-j][N-1-k] = temp;
					arr270[N-1-k][j] = temp;
				}
			}
			System.out.println("#" + i);
			for(int j=0; j < N; j++) {
				for(int  k = 0; k < N; k++) {
					System.out.print(arr90[j][k]);
				}
				System.out.print(" ");
				for(int  k = 0; k < N; k++) {
					System.out.print(arr180[j][k]);
				}
				System.out.print(" ");
				for(int  k = 0; k < N; k++) {
					System.out.print(arr270[j][k]);
				}
				System.out.println();
			}
		}
		
	}
}
