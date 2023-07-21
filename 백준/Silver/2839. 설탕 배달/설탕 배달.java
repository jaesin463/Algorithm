import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int kilo = sc.nextInt();

		int n5kg = 0;

		int Min = 5000;

		for (int i = 0; i <= kilo / 3; i++) {
			if ((kilo - 3 * i) % 5 == 0) {
				n5kg = (kilo - 3 * i) / 5;
				Min = Math.min(Min, n5kg + i);
			}
		}

		if (Min == 5000) {
			System.out.println(-1);
		} else {
			System.out.println(Min);
		}
	}
}
