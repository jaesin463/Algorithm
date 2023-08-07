import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i = 0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i = 0;i<10;i++) {
			int temp = sum;
			sum += arr[i];
			if(sum>=100) {
				if((100-temp)>=(sum-100)) {
					System.out.println(sum);
				} else {
					System.out.println(temp);
				}
				return;
			}
		}
		System.out.println(sum);
	}

}
