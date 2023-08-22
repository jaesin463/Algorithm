import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double money = sc.nextDouble();
		
		System.out.println((int)(money * 0.78) + " " + (int)(money - (money * 0.2 * 0.22)));
	}
}
