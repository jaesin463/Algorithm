import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int az = sc.nextInt();
		int cx = sc.nextInt();
		int cy = sc.nextInt();
		int cz = sc.nextInt();
		System.out.print(cx - az);
		System.out.print(" ");
		System.out.print(cy / ay);
		System.out.print(" ");
		System.out.print(cz - ax);
//		a.z + b.x, a.y × b.y, a.x + b.z
	}
}
