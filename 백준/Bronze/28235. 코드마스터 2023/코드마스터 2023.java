import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();
		switch(name) {
		case "SONGDO":
			System.out.println("HIGHSCHOOL");
			break;
		case "CODE":
			System.out.println("MASTER");
			break;
		case "2023":
			System.out.println("0611");
			break;
		case "ALGORITHM":
			System.out.println("CONTEST");
			break;
		}
		
	}
}
