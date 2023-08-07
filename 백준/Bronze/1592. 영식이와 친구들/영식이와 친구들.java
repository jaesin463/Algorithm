import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] count = new int[N];
		int index = 0;
		count[index] = 1;
		int ball = 0;
		while(count[index]<M) {
			ball++;
			if(count[index]%2==0) {
				index = (N+index-L)%N;
				count[index]++;
			} else {
				index = (index+L)%N;
				count[index]++;
			}
		}
		System.out.println(ball);
	}

}