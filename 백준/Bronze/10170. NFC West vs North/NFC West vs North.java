import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		System.out.println("NFC West       W   L  T");
		System.out.println("-----------------------");
		System.out.println("Seattle        13  3  0");
		System.out.println("San Francisco  12  4  0");
		System.out.println("Arizona        10  6  0");
		System.out.println("St. Louis      7   9  0");
		System.out.println();
		System.out.println("NFC North      W   L  T");
		System.out.println("-----------------------");
		System.out.println("Green Bay      8   7  1");
		System.out.println("Chicago        8   8  0");
		System.out.println("Detroit        7   9  0");
		System.out.println("Minnesota      5  10  1");

	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
