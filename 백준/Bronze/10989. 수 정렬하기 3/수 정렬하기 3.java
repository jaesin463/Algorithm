import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		int nNum = Integer.parseInt(br.readLine());
		
		int[] num = new int[nNum];
		
		for(int i = 0; i < nNum; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		for(int i = 0; i < nNum; i++) {
			sb.append(num[i]).append('\n');
		}
		
		System.out.println(sb);
	}
}