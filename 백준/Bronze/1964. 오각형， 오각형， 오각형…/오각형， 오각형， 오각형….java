import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
								
		long num = Integer.parseInt(br.readLine());
			
		System.out.println((num*(3*num + 5)/2 + 1)%45678);
				
	}
}