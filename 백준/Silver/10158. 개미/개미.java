import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int time = Integer.parseInt(br.readLine());

		int Xt = time % (2 * w);
		int Yt = time % (2 * h);

		if (Xt <= w - x) {
			x = x + Xt;
		} else if (Xt <= (2 * w) - x) {
			x = 2 * w - x - Xt;
		} else {
			x = Xt - (2 * w) + x;
		}

		if (Yt <= h - y) {
			y = y + Yt;
		} else if (Yt <= (2 * h) - y) {
			y = 2 * h - y - Yt;
		} else {
			y = Yt - (2 * h) + y;
		}
		
		System.out.println(x + " " + y);
	}
}
