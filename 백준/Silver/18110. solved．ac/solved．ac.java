import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nNum = Integer.parseInt(br.readLine());
		
		int[] num = new int[nNum];
		
		for(int i = 0; i < nNum; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
				
		int i = (int)Math.round(nNum * 0.15);
		double sum = 0;
		for(int j = i; j < nNum - i; j++) {
			sum += num[j];
		}
		
		sum = Math.round(sum / (nNum-(2*i)));
		
		System.out.printf("%.0f", sum);
	}
}
