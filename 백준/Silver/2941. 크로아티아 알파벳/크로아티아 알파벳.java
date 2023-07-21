import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		int count = 0;	
		int prev = 0;
		
		for(int c=System.in.read();c>='-'; c=System.in.read()) {
			if(c=='='||c=='-') {
				if(c=='=' && prev==-1) count--;
			}else {
				if(c=='z'&&prev=='d') {
					prev = -1;
					count++;
					continue;
				}else {
					if(!(c=='j'&&(prev=='l'||prev=='n'))) count++;
				}
			}
			
			prev = c;
		}
		
		System.out.print(count);
		
	}
}