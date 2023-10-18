import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static long C = 0;
	static Map<Integer, Integer> level = new HashMap<>();
	static TreeSet<Integer> set = new TreeSet<Integer>();

	static void make() throws IOException {
		int N = init();

		int start = init();
		set.add(start);
		level.put(start, 0);
		set.add(0);
		level.put(0, 0);
		set.add(N + 1);
		level.put(N + 1, 0);
		sb.append(C).append("\n");
		for (int i = 1; i < N; i++) {
			int num = init();
			set.add(num);
			Integer up = set.higher(num);
			Integer down = set.lower(num);

			int NL = Math.max(level.get(up), level.get(down)) + 1;
			level.put(num, NL);
			C += NL;
			sb.append(C).append("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		System.out.println(sb);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}