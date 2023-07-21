import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		int paper[][] = new int[100][100];
		
		int n_paper = in.nextInt();
		
		int x, y;
		int count = 0;
				
		for(int i = 1; i <= n_paper; i++) {
			x = in.nextInt();
			y = in.nextInt();
			
			for(int row = y - 1; row < y + 9; row++) {
				for(int col = x - 1; col < x + 9; col++) {
					paper[row][col] = 1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1) count++;
			}
		}
		
		System.out.print(count);

	}
}