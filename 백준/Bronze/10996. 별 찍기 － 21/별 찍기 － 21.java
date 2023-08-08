import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println("*");
			return;
		}

		for (int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j += 2) {
				System.out.print("* ");
			}
			System.out.println();
			for(int j = 1 ; j < N; j += 2) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
}
