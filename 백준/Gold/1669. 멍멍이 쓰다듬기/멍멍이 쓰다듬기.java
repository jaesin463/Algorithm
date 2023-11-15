import java.io.*;
import java.util.*;

public class Main {
	static int X,Y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		
		int diff = Y-X;
		long n = 0;
		
		if(X==Y) {
			System.out.println(0);
			return;
		}
		
		while(n*n < diff) {
			n++;
		}
		
		if(n*n != diff) {
			n--;
		}
		
		long ans = 2*n-1;
		diff -= n*n;
		
		while(diff > 0) {
			diff -= Math.min(n, diff);
			ans++;
		}
		
		System.out.println(ans);

	}

}