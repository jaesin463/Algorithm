import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int start, end, dist;
	static int sqrtD;

	static void solution() {
		sqrtD = (int) Math.sqrt(dist);

		if (dist == sqrtD * sqrtD)
			sb.append((sqrtD << 1) - 1).append("\n");
		else if (dist <= sqrtD * sqrtD + sqrtD)
			sb.append((sqrtD << 1)).append("\n");
		else
			sb.append((sqrtD << 1) + 1).append("\n");
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		start = init(st);
		end = init(st);
		dist = end - start;
	}

	public static void main(String[] args) throws IOException {
		int T = init();
		while (T-- > 0) {
			make();
			solution();
		}
		System.out.println(sb);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}
