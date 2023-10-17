import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, B, C, Ai;
	static long cntB, cntC1 = 0, cntC2 = 0;

	// 무조건 B원은 결제해야 되고 A[i]에서 몇개를 샀느냐에 따라 C원으로 살 수 있는 기회가 주어짐
	static void solution() throws IOException {
		// 필요한 금액
		long ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// 현재 공장에서 사야하는 라면 개수
			Ai = init(st);
			// 싸게 살 수 있는 기회보다 이번 공장의 라면 수가 더 적을 수도 있음
			cntC1 = Math.min(cntC1, Ai);
			cntB = Ai - cntC1;
			// B원으로 사는 횟수 + C원으로 사는 횟수
			ans += (B * cntB) + (C * cntC1);
			// A[i+1]에서 기회보다 적게 샀다면 가능한 횟수가 줄어야 함
			cntC2 = Math.min(cntC2, Ai);
			// 다음 공장에서 C원으로 살 수 있는 기회는 cntC2 + 이번에 B로 산 횟수
			cntC1 = cntC2 + cntB;
			// 다다음 공장에서 C원으로 살 수 있는 기회는 이번에 B로 산 횟수
			cntC2 = cntB;
		}

		System.out.println(ans);
	}

	static void make() throws IOException {
		st = new StringTokenizer(br.readLine());
		// 전체 공장의 수
		N = init(st);
		// B원
		B = 3;
		// C원
		C = 2;
	}

	public static void main(String[] args) throws IOException {
		make();
		solution();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) throws IOException {
		return Integer.parseInt(st.nextToken());
	}
}