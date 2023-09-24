import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int result[];
	static boolean visited[];

	static void recur(int depth) {
		if(depth == M) {
			for(int i = 0 ; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1 ; i < N + 1; i++) {
			if(!visited[i]) {
				result[depth] = i;
				visited[i] = true;
				recur(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	static void solution() throws IOException {
		recur(0);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new boolean[N + 1];
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}