import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		System.out.println((init(st.nextToken())+ 1) * (init(st.nextToken()) + 1) / (init(st.nextToken())+ 1) - 1);

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
