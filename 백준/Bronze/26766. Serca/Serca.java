import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void makeHeart() {
		System.out.println(" @@@   @@@ ");
		System.out.println("@   @ @   @");
		System.out.println("@    @    @");
		System.out.println("@         @");
		System.out.println(" @       @ ");
		System.out.println("  @     @  ");
		System.out.println("   @   @   ");
		System.out.println("    @ @    ");
		System.out.println("     @     ");
	}
	
	public static void main(String[] args) throws IOException {
		int N = init(br.readLine());
		
		for(int i = 0; i < N; i++) {
			makeHeart();
		}
		
		
		
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