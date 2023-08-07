import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		for(int i = 1;i<=N;i++) {
			for(int j = 1;j<Math.sqrt(i);j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(i%Math.sqrt(i)==0) {
				count++;
			}
		}
		System.out.println(count);
	}
}