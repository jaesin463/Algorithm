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
	static long C = 1;
	static Map<Integer, Integer> level = new HashMap<>();
	static TreeSet<Integer> set = new TreeSet<Integer>();

	static void make() throws IOException {
		int N = init();

		int start = init();
		set.add(start);
		level.put(start, 1);
		set.add(-1);
		level.put(-1, 1);
		set.add(N + 1);
		level.put(N + 1, 1);
		for (int i = 1; i < N; i++) {
			int num = init();
			set.add(num);
			Integer up = set.higher(num);
			Integer down = set.lower(num);

			int NL = Math.max(level.get(up), level.get(down)) + 1;
			level.put(num, NL);
			C += NL;
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		System.out.println(C);
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}