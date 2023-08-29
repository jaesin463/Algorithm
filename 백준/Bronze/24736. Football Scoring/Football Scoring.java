import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int sum(int[] score, int result) {
		return result = score[0] * 6 + score[1] * 3 + score[2] * 2 + score[3] + score[4] * 2;
	}
	
	public static void main(String[] args) throws IOException {
		int[] scoreA = new int[5];
		int[] scoreB = new int[5];
		int sumA = 0;
		int sumB = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++) {
			scoreA[i] = init(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++) {
			scoreB[i] = init(st.nextToken());
		}
		
		
		System.out.println(sum(scoreA, sumA) + " " + sum(scoreB, sumB));
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
