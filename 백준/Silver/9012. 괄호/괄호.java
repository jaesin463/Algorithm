import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		int count = 0;
		
		String VPS;
		
		for(int i = 1; i <= test_case; i++) {
			VPS = sc.next();
			count = 0;
			
			for(int j = 0; j < VPS.length() ; j++) {
				if(VPS.charAt(j) == '(') count++;
				else if(count == 0 && VPS.charAt(j) == ')') {
					count = 1;
					break;
				}
				else count--;
			}
			System.out.println(count == 0 ? "YES" : "NO");
		}
	}
}