import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int length = Integer.parseInt(br.readLine());

		String hash = br.readLine();

		long result = 0;
		long pow = 1;
		for (int i = 0; i < length; i++) {
			result += ((hash.charAt(i) - 96) * pow % 1234567891);
			pow = pow * 31 % 1234567891;
		}

		System.out.println(result);

	}
}