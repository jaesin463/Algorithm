import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int Facto = Integer.parseInt(br.readLine());
									
		System.out.print(((Facto / 5) + (Facto / 25) + (Facto / 125)));
		
	}
}