import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc = 1; tc <= 10; tc++) {
        	br.readLine();
        	
        	int Sum = 0;
        	int max = 0;
        	
        	int[][] arr = new int[100][100];
        	
        	for(int i = 0; i < 100; i++) {
        		st = new StringTokenizer(br.readLine());
        		Sum = 0;
        		for(int j = 0; j < 100; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        			Sum += arr[i][j];
        		}
        		max = Math.max(max,  Sum);
        	}
        	
        	for(int i = 0; i < 100; i++) {
        		Sum = 0;
        		for(int j = 0; j < 100; j++) {
        			Sum += arr[j][i];
        		}
        		max = Math.max(max, Sum);
        	}
        	Sum = 0;
        	for(int  i = 0; i < 100; i++) {
        		Sum += arr[i][i];
        	}
        	max = Math.max(max, Sum);
        	Sum = 0;
        	for(int  i = 0; i < 100; i++) {
        		Sum += arr[i][99 - i];
        	}
        	max = Math.max(max, Sum);
        	
        	System.out.printf("#%d %d\n", tc, max);
        	
        }
        
    }
}