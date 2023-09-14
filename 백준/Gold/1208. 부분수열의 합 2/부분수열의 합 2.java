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
	static int N, S;
	static int[] num;
	static List<Integer> lSumList = new ArrayList<>();
	static List<Integer> rSumList = new ArrayList<>();
	static long count = 0;

	static void cntSum() {
		int left = 0;
		int right = rSumList.size() - 1;

		while (left < lSumList.size() && right >= 0) {
			int l = lSumList.get(left);
			int r = rSumList.get(right);
			if (l + r == S) {
				long rcnt = 0;
				while (right >= 0 && rSumList.get(right) == r) {
					right--;
					rcnt++;
				}
				long lcnt = 0;
				while (left < lSumList.size() && lSumList.get(left) == l) {
					left++;
					lcnt++;
				}
				count += lcnt * rcnt;
			} else if (l + r < S)
				left++;
			else if (l + r > S)
				right--;
		}

	}

	static void makeList(int depth, int end, int sum, List<Integer> sumList) {
		if (depth == end) {
			sumList.add(sum);
			return;
		}

		makeList(depth + 1, end, sum + num[depth], sumList);
		makeList(depth + 1, end, sum, sumList);
	}

	static void solution() {
		makeList(0, (N - 1) / 2, 0, lSumList);
		makeList((N - 1) / 2, N, 0, rSumList);
		Collections.sort(lSumList);
		Collections.sort(rSumList);
		cntSum();
		System.out.println(S == 0 ? count - 1 : count);

	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		// 입력 값 할당
		N = init(st.nextToken());
		S = init(st.nextToken());

		// N개의 요소를 가진 배열 생성
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = init(st.nextToken());
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
