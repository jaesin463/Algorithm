import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		String alpha = in.next();
		int num[] = new int[26];
		int max = 0;
		int max2 = 0;
		int count = 0;
		
		
		
		for (int i = 0; i < alpha.length(); i++) {
			if ((int)alpha.charAt(i) < 91)
				num[(int)alpha.charAt(i) - 65]++;
			else
				num[(int)alpha.charAt(i) - 97]++;
		}
		
		for (int i = 0; i < 26; i++) {
			if (max <= num[i]) {
				max2 = max;
				max = num[i];
				count = i;
				}
		}

		if (max == max2)
			System.out.print("?");
		else
			System.out.print((char)(count+65));
		
	}
}