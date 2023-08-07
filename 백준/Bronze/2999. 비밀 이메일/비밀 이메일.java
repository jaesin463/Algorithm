import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N = str.length();
		int R = 0;
		int C = 0;
		for(int i = 1;i<=Math.sqrt(N);i++) {
			if(N%i==0) {
				R = Math.max(R, i);
				C = N/R;
			}
		}
		char[][] arr = new char[C][R];
		int idx = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr[0].length;j++) {
				arr[i][j] = str.charAt(idx++);
			}
		}
		String result = "";
		for(int j = 0;j<arr[0].length;j++) {
			for(int i = 0;i<arr.length;i++) {
				result += arr[i][j];
			}
		}
		System.out.println(result);
	}

}