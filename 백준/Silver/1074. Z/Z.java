import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, r, c;
	static int cnt = 0;

	static void partition(int len, int row, int col, int start) {
		if (len == 1) {
			System.out.println(start);
			return;
		}
		len /= 2;

		int count = len * len;
		if (r < row + len && c < col + len)
			partition(len, row, col, start);
		else if (r < row + len && c >= col + len)
			partition(len, row, col + len, start + count);
		else if (r >= row + len && c < col + len)
			partition(len, row + len, col, start + count * 2);
		else
			partition(len, row + len, col + len, start + count * 3);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = (int) Math.pow(2, init(st.nextToken()));
		r = init(st.nextToken());
		c = init(st.nextToken());
	}

	public static void main(String[] args) throws IOException {
		make();
		partition(N, 0, 0, 0);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}