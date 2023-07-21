import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int X = in.nextInt();
		int i = 0;
		int tempX = 1;
		int tempY = 1;
		int count = 1;
		
		while(true) {
			i += count;
			
			if(i >= X) {
				i -= count;
				break;
			}
						
			count++;
		}
		
		if(count%2 == 1) {
			tempX = count;
			tempY = 1;
			i++;
			for(int j = 1; j <= count; j++) {
				if(i == X) break;
				i++;
				tempX--;
				tempY++;
			}
		}else if(count%2 == 0) {
			tempX = 1;
			tempY = count;
			i++;
			for(int j = 1; j <= count; j++) {
				if(i == X) break;
				i++;
				tempX++;
				tempY--;
			}
		}
		
		System.out.printf("%d/%d", tempX, tempY);
				
	}
}