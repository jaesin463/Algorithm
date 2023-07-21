import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int size = 0;
	static int[] stack = new int[100000];
	static int idx = 1;

	public static boolean push(int num) {
		if (num < idx)
			return false;
		stack[size++] = idx++;
		return true;
	}

	public static void pop() {
		stack[size - 1] = 0;
		size--;

	}

	public static int top() {
		if (size - 1 < 0)
			return stack[0];
		return stack[size - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		boolean PM = true;

		Loop1: for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (top() < temp) {
				while (top() != temp) {
					if (PM == false) {
						break Loop1;
					} else {
						PM = push(temp);
						result.append("+\n");
					}
				}
			}

			while (true) {
				if (top() == temp) {
					pop();
					result.append("-\n");
					break;
				}
				pop();
				result.append("-\n");
			}
		}

		if (PM == false) {
			System.out.println("NO");
		} else {
			System.out.println(result);
		}

	}
}