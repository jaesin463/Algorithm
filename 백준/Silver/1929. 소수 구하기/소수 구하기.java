import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int start = sc.nextInt();
		int end = sc.nextInt();

		boolean tf;

		if (start == 1)	start = 2;

		if (end >= 2) {
			for (int i = start; i <= end; i++) {
				tf = true;
				for (int j = 2; j <= (int)Math.sqrt(i); j++) {
					if (i % j == 0) {
						tf = false;
						break;
					}
				}
				if (tf == true)
					System.out.println(i);
			}
		}
	}
}