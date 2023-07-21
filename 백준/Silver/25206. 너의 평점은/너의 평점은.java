import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		String sub[][] = new String[3][20];
		double sum = 0;
		int nsub = 0;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 3; j++) {
				sub[j][i] = in.next();
			}
		}

		for (int i = 0; i < 20; i++) {
			switch (sub[2][i]) {
			case "A+":
				sum += Double.parseDouble(sub[1][i]) * 4.5;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "A0":
				sum += Double.parseDouble(sub[1][i]) * 4;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "B+":
				sum += Double.parseDouble(sub[1][i]) * 3.5;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "B0":
				sum += Double.parseDouble(sub[1][i]) * 3;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "C+":
				sum += Double.parseDouble(sub[1][i]) * 2.5;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "C0":
				sum += Double.parseDouble(sub[1][i]) * 2;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "D+":
				sum += Double.parseDouble(sub[1][i]) * 1.5;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "D0":
				sum += Double.parseDouble(sub[1][i]) * 1;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "F":
				sum += Double.parseDouble(sub[1][i]) * 0;
				nsub += Double.parseDouble(sub[1][i]);
				break;
			case "P":
				break;
			}
		}
		System.out.print(sum / nsub);
	}
}