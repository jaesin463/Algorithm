import java.util.Scanner;
public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(true){
        int a = sc.nextInt();
		int b = sc.nextInt();
            if(a == b && b ==0) break;
		System.out.println(a+b);    
        }
        
	}
}
