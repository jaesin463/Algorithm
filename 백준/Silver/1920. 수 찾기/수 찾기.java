import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nNum = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nNum[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nNum);
		
				
		int M = Integer.parseInt(br.readLine());
				
		int low, high, mid;
		
		st = new StringTokenizer(br.readLine());
		
		Loop1 : for(int i = 0, temp = 0; i < M; i++) {
			temp = Integer.parseInt(st.nextToken());
			
			low = 0;
			high = N-1;
						
			while(low <= high) {
				mid = (low + high) / 2;
				
				if(nNum[mid] == temp) {
					sb.append("1\n");
					continue Loop1;
				}
				else if(nNum[mid] > temp) {
					high = mid - 1;
				}
				else if(nNum[mid] < temp){
					low = mid + 1;
				}
			}
			
			sb.append("0\n");
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}

}
