import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, maxLength;
	static int[] A = new int[1000001];
	static int[] B = new int[1000001];
	static int[] D = new int[1000001];
	static int[] ans = new int[1000001];

	static int binarysearch(int left, int right, int now) {
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(B[mid] < now)
				left = mid +1;
			else
				right = mid;
		}
		return left;
	}

	public static void main(String[] args) throws IOException {
		N = init(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = init(st.nextToken());
		}
		int idx;
		B[++maxLength] = A[1];
		D[1] = 1;
		for (int i = 2; i <= N; i++) {
			if (B[maxLength] < A[i]) {
				B[++maxLength] = A[i];
				D[i] = maxLength;
			} else {
				idx = binarysearch(1, maxLength, A[i]);
				B[idx] = A[i];
				D[i] = idx;
			}
		}

		System.out.println(maxLength);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - '0';
	}

	static void check(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void check(char[][] arr) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
	}
}