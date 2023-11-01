import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 각 샘플의 값과 인덱스 저장
// value: 최소 최대
// index: 범위 확인  
class Sample {
	int value, index;

	public Sample() {
	}

	public Sample(int value, int index) {
		this.value = value;
		this.index = index;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	// 사일런스 최저값과 최고값의 차이가 c를 넘지 않는 샘플 m개의 연속
	// n: 샘플의 수, m: 연속 되어야 하는 조건, c: 최저, 최고 차이 기준
	static int n, m, c;
	static Deque<Sample> dqMin = new ArrayDeque<>();
	static Deque<Sample> dqMax = new ArrayDeque<>();

	public static void solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		// 레코딩 내 사일런스 등장 구간의 횟수
		int silence = 0;
		int start = init(st);
		// 시작 값 셋팅
		dqMin.offerLast(new Sample(start, 1));
		dqMax.offerLast(new Sample(start, 1));

		for (int i = 2; i < n + 1; i++) {
			// 덱의 가장 앞에 최저, 최고값을 각각 저장
			// 인덱스를 확인하며 갱신
			// 덱 안에서 정렬된 상태를 유지했으면 하는데
			int sample = init(st);
			// 현재 덱에 있는 최저값이 윈도우 안에 있는지 확인
			if (!dqMin.isEmpty() && dqMin.peekFirst().index <= i - m)
				dqMin.pollFirst();

			// 현재 덱에 있는 최고값이 윈도우 안에 있는지 확인
			if (!dqMax.isEmpty() && dqMax.peekFirst().index <= i - m)
				dqMax.pollFirst();

			// 이번 샘플의 값이 덱에서 내림차순으로 들어가도록
			while (!dqMin.isEmpty() && dqMin.peekLast().value >= sample)
				dqMin.pollLast();
			dqMin.offerLast(new Sample(sample, i));

			// 이번 샘플의 값이 덱에서 오름차순으로 들어가도록
			while (!dqMax.isEmpty() && dqMax.peekLast().value <= sample)
				dqMax.pollLast();
			dqMax.offerLast(new Sample(sample, i));

			// m 이상 됐을 때 부터
			if (i >= m && dqMax.peekFirst().value - dqMin.peekFirst().value <= c) {
				sb.append(i - m + 1).append("\n");
				silence++;
			}
		}
		System.out.println(sb.length() == 0 ? "NONE" : sb);
	}

	public static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = init(st);
		m = init(st);
		c = init(st);
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	public static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	public static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

}