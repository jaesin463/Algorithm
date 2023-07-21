import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		String end = "666";
		
		int num = 0;
		
		for(int i = 1; a != 0; i++) {
			if(String.valueOf(i).contains(end)) {
				num = i;
				a--;
			}
		}
		
		System.out.print(num);

	}
}
