import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	테스트 케이스의 개수
	static int test_case;
//	자연수의 개수
	static int nNum;

	public static int resSum(String str) {
		int result = 1;
		int idx = 0;
		char plusMinus = ' ';
		str = str.replaceAll(" ", "");

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				if (plusMinus == ' ') {
					result = Integer.parseInt(str.substring(idx, i));
				} else if (plusMinus == '+') {
					result = result + Integer.parseInt(str.substring(idx, i));
				} else if (plusMinus == '-') {
					result = result - Integer.parseInt(str.substring(idx, i));
				}

				idx = i + 1;
				plusMinus = str.charAt(i);
			}
		}
		if (plusMinus == '+') {
			result = result + Integer.parseInt(str.substring(idx));
		} else if (plusMinus == '-') {
			result = result - Integer.parseInt(str.substring(idx));
		}

		return result;
	}

	public static void zeroSum(int depth, int num, String str) {

		if (depth == nNum) {
			if (resSum(str) == 0) {
				System.out.println(str);
			}
			return;
		}

		zeroSum(depth + 1, num + 1, str + ' ' + (num + 1));
		zeroSum(depth + 1, num + 1, str + '+' + (num + 1));
		zeroSum(depth + 1, num + 1, str + '-' + (num + 1));

	}

	public static void main(String[] args) throws IOException {

		test_case = Integer.parseInt(br.readLine());

		for (int i = 0; i < test_case; i++) {
			nNum = Integer.parseInt(br.readLine());

			zeroSum(1, 1, "1");

			System.out.println();
		}

	}
}