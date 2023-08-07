import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] hobbit = new int[9];

		for (int i = 0; i < 9; i++) {
			hobbit[i] = Integer.parseInt(br.readLine());
		}

		int idx = 7;
		int idx2 = 8;


		while (true) {
			int sum = 0;
			
			for (int i = 0; i < 9; i++) {
				if (i == idx || i == idx2) {
					continue;
				}
				sum += hobbit[i];
			}
			
			if (sum == 100) {
				break;
			}

			if (idx == 0) {
				idx2--;
				idx = idx2 - 1;
			} else {
				idx--;
			}
		}
		
		hobbit[idx] = 0;
		hobbit[idx2] = 0;
		
		Arrays.sort(hobbit);
		
		for(int i = 2; i < 9; i++){
			System.out.println(hobbit[i]);
		}
	}
}
