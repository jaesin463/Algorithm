import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a1 = sc.nextInt();
		int a0 = sc.nextInt();
		int c = sc.nextInt();
		int n0 = sc.nextInt();
		
		System.out.print((a0 <= ((c-a1) * n0)) && c >= a1 ? 1 : 0);
	
	}
}
