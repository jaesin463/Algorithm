import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, cnt;
	static int[] student;
	static boolean[] visited;
	static boolean[] team;

	static void dfs(int n) {
		if (visited[n]) {
			team[n] = true;
			cnt++;
		}
		else {
			visited[n] = true;
		}
		
		if(!team[student[n]])
			dfs(student[n]);
		
		visited[n] = false;
		team[n] = true;
	}

	static void solution() {
		visited = new boolean[N + 1];
		team = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (!team[i]) {
				dfs(i);
			}
		}
		sb.append(N - cnt);
		sb.append("\n");
	}

	static void make() throws IOException {
		N = init(br.readLine());
		student = new int[N + 1];
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			student[i] = init(st.nextToken());
		}
	}

	public static void main(String[] args) throws IOException {
		int T = init(br.readLine());
		for (int i = 0; i < T; i++) {
			make();
			solution();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean index(int r, int c) {
		if (r < N && r >= 0 && c < N && c >= 0)
			return true;
		return false;
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
