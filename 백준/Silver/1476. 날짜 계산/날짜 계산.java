import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int eM, sM, mM;
		
		for(int i = 1; i <= 7980; i++) {
			eM = i % 15;
			sM = i % 28;
			mM = i % 19;
			
			if(eM == 0) eM = 15;
			if(sM == 0) sM = 28;
			if(mM == 0) mM = 19;
			
			if(eM == E && sM == S && mM == M) {
				System.out.println(i);
				break;
			}
		}
		
		
	}
}
