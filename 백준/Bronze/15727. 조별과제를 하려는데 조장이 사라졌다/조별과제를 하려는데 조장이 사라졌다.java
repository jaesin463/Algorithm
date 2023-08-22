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

		int N = init(br.readLine());

		System.out.println(N % 5 == 0 ? N / 5 : N / 5 + 1);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
