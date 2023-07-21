import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		int test_case = in.nextInt();
		int count = 0;

		for (int t = 1; t <= test_case; t++) {
			String word = in.next();

			boolean group = true;

			for (int i = 0; i < word.length() - 1; i++) { // 글자수 만큼 확인
				if (word.charAt(i) != word.charAt(i + 1)) { // i번째 글자와 i+1번째 글자가 다를 때
					if (i <= word.length() - 3) { // 근데 i 가 글자수보다 3만큼 작으면
						for (int j = i + 2; j < word.length(); j++) { // i+2와 i를 비교
							if (word.charAt(i) == word.charAt(j)) {
								group = false;
								break;
							}
						}
					}
				}
				if (group == false)
					break;
			}

			if (group == true)
				count++;
		}

		System.out.print(count);

	}
}