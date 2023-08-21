import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = init(st.nextToken());
		int S = init(st.nextToken());
		
		if((T >= 12 && T <= 16 ) && S == 0) {
			System.out.println("320");
		} else {
			System.out.println("280");
		}

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
