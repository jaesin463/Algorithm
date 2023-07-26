import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int length = Integer.parseInt(br.readLine());
		
		String hash = br.readLine();
		
		int result = 0;
		
		for(int i = 0; i < length; i++) {
			result += ((hash.charAt(i) - 96) * Math.pow(31, i));
		}
		
		System.out.println(result % 1234567891);
		
	}
}