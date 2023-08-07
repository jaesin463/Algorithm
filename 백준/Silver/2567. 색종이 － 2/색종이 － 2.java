import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int nPaper = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[101][101];
		
		for(int i = 0; i < nPaper ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					graph[j][k] = 1;
				}
			}
		}
		
		int cnt = 0;
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(i-1>=0 && graph[i][j] == 1 && graph[i-1][j] == 0) cnt++;
				if(i+1<101 && graph[i][j] == 1 && graph[i+1][j] == 0) cnt++;
				if(j-1>=0 && graph[i][j] == 1 && graph[i][j-1] == 0) cnt++;
				if(j+1<101 && graph[i][j] == 1 && graph[i][j+1] == 0) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
