import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] pi;
	static List<Integer> result = new ArrayList<>();
	static int cnt = 0;

	public static void search(String str, String pattern) {
		// 문자열 길이 sLen, 패턴 길이 pLen
		int sLen = str.length();
		int pLen = pattern.length();
		// 현재까지 일치하는 패턴의 길이
		int index = 0;
		// 문자열 길이만큼 순회
		for (int i = 0; i < sLen; i++) {
			// index > 0 첫 문자가 같아 패턴 매칭이 시작
			// str.charAt(i) != pattern.charAt(index) 연속으로 일치하지 않는 경우
			while (index > 0 && str.charAt(i) != pattern.charAt(index)) {
				// index 값을 돌려주고 다시 시작
				index = pi[index - 1];
			}
			// 패턴이 연속으로 일치하는 경우
			if (str.charAt(i) == pattern.charAt(index)) {
				// 문자열에서 패턴 발견 완료
				if (index == pLen - 1) {
					// 여러개를 찾을 경우 대비 index 재조정
					result.add(i - index + 1);
					index = pi[index];
					// 찾기에 성공
					cnt++;
				}
				// 아직 더 비교해야 하는 경우
				else {
					// 다음 패턴 비교
					index++;
				}
			}
		}
	}

	// 이동경로 테이블( pi[] )
	public static void makeTable(String pattern) {
		// 패턴의 길이
		int pLen = pattern.length();
		// 패턴 길이만큼 배열 초기화
		pi = new int[pLen];

		int prefix = 0;
		for (int suffix = 1; suffix < pLen; suffix++) {
			// prefix > 0 첫 문자가 같아 패턴 매칭이 시작
			// str.charAt(suffix) != pattern.charAt(prefix) 연속으로 일치하지 않는 경우
			while (prefix > 0 && pattern.charAt(suffix) != pattern.charAt(prefix)) {
				prefix = pi[prefix - 1];
			}
			// 일치하는 경우 접두사의 길이 저장
			if (pattern.charAt(suffix) == pattern.charAt(prefix)) {
				prefix += 1;
				pi[suffix] = prefix;
			}
		}
	}

	static void make() throws IOException {
		String str = br.readLine();
		String pattern = br.readLine();

		makeTable(pattern);
		search(str, pattern);
		System.out.println(cnt);
		for(int i = 0; i < result.size(); i++)
			System.out.print(result.get(i) + " ");
	}

	public static void main(String[] args) throws IOException {
		make();
	}

	static int init() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static int init(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
}