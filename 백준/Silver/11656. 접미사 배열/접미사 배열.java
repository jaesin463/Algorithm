import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String[] str = new String[S.length()];
		
		for(int i = 0; i < S.length(); i++) {
			str[i] = S.substring(i, S.length());
		}
		
		Arrays.sort(str);
		
		for(int i = 0; i < S.length(); i++) {
			System.out.println(str[i]);
		}
		
		
		
	}
}