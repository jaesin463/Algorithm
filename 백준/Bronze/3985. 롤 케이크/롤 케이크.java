import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();

		boolean[] cake = new boolean[L+1];
		int[] want = {0, 0};
		int[] get = {0, 0};
		for(int i = 0;i<N;i++) {
			int eat = 0;
			int start = sc.nextInt();
			int end = sc.nextInt();
			for(int j = start;j<=end;j++) {
				if(cake[j]==false) {
					eat++;
				}
				cake[j] = true;
			}
			if(get[1]<eat) {
					get[1]=eat;
					get[0] = i+1;
			}
			if(want[1]<(end-start+1)) {
				want[1]=(end-start+1);
				want[0] = i+1;
			}
		}
		System.out.println(want[0]);
		System.out.println(get[0]);
	}

}