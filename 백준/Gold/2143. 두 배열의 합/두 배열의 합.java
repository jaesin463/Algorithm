import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int S;
	static int N, M;
	static int[] A;
	static int[] B;
	static List<Integer> aSumList = new ArrayList<>();
	static List<Integer> bSumList = new ArrayList<>();
	static long count = 0;

	static void cntSum() {
		int a = 0;
		int b = bSumList.size() - 1;

		while (a < aSumList.size() && b >= 0) {
			int l = aSumList.get(a);
			int r = bSumList.get(b);
			if (l + r == S) {
				long rcnt = 0;
				while (b >= 0 && bSumList.get(b) == r) {
					b--;
					rcnt++;
				}
				long lcnt = 0;
				while (a < aSumList.size() && aSumList.get(a) == l) {
					a++;
					lcnt++;
				}
				count += lcnt * rcnt;
			} else if (l + r < S)
				a++;
			else if (l + r > S)
				b--;
		}

	}

	static void makeList(int end, List<Integer> sumList, int[] num) {
		for (int i = 0; i < end; i++) {
			int sum = num[i];
			sumList.add(sum);
			for (int j = i + 1; j < end; j++) {
				sum += num[j];
				sumList.add(sum);
			}
		}
	}

	static void solution() {
		makeList(N, aSumList, A);
		makeList(M, bSumList, B);
		Collections.sort(aSumList);
		Collections.sort(bSumList);
		cntSum();
		System.out.println(count);
	}

	static void make() throws IOException {
		S = init(br.readLine());

		N = init(br.readLine());
		// N개의 요소를 가진 배열 생성
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = init(st.nextToken());
		}

		M = init(br.readLine());
		// N개의 요소를 가진 배열 생성
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = init(st.nextToken());
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}
