import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int size = 0;
	static int[] Stack = new int[10000];

	public static void push(int num) {
		Stack[size++] = num;
	}

	public static int pop() {
		if (size == 0)
			return -1;
		else {
			int temp = Stack[size - 1];
			Stack[size - 1] = 0;
			size--;
			return temp;
		}
	}

	public static int size() {
		return size;
	}

	public static int empty() {
		if (size == 0)
			return 1;

		return 0;
	}

	public static int top() {
		if (size == 0)
			return -1;
		else
			return Stack[size - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		for (int i = 1; i <= test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "top":
				System.out.println(top());
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			}
		}
	}
}