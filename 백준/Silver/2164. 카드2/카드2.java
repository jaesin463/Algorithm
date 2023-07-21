import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		double i = 0;
		
		while(true) {
			// 2^i < num <= 2^(i+1)
			if(num == 1) {
				System.out.print(1);
				break;
			}
			
			if(Math.pow(2, i) < num && num <= Math.pow(2, i + 1)) {
				System.out.print(2 * (num - (int)Math.pow(2, i) )  );
				break;
			}

			i++;
		}
	}
}
