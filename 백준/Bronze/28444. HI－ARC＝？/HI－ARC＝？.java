import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int H = init(st.nextToken());
		int I = init(st.nextToken());
		int A = init(st.nextToken());
		int R = init(st.nextToken());
		int C = init(st.nextToken());
		
		int result = H * I - A * R * C;
		System.out.println(result);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - '0';
	}

	static void check(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}