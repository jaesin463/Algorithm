import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] girl = new int[6];
		int[] boy = new int[6];
		for(int i = 0;i<N;i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			if(S==0) {
				girl[Y-1]++;
			} else {
				boy[Y-1]++;
			}
		}
		int room = 0;
		for(int i = 0;i<6;i++) {
			room += Math.ceil(girl[i]/(double)K);
			room += Math.ceil(boy[i]/(double)K);
		}
		System.out.println(room);
	}
}