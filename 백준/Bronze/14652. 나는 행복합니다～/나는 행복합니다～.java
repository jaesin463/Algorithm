import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		int N = init(st.nextToken());
		int M = init(st.nextToken());
		int K = init(st.nextToken());
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(idx++ == K) {
					System.out.println(i + " " + j);
					System.exit(0);
				}
			}
		}
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
