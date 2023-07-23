import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long num = Integer.parseInt(br.readLine());
		long result = 1;
		
		for(int i = 1; i <= num; i++) {
			result = result + 3*i + 1 ;
		}
		
		System.out.println(result % 45678);
	}
}