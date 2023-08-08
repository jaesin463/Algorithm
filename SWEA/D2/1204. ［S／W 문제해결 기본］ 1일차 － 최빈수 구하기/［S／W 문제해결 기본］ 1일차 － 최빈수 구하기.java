import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void selectSort(int[] num) {
		int max, temp;
		for (int i = num.length - 1; i > 0; i--) {
			max = 0;
			for (int j = 1; j <= i; j++) {
				if (num[max] < num[j]) {
					max = j;
				}
			}
			if (max == i)
				continue;
			temp = num[max];
			num[max] = num[i];
			num[i] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			Integer.parseInt(br.readLine());
			int[] score = new int[101];
			// 입력 값 할당
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 1000; i++) {
				score[Integer.parseInt(st.nextToken())]++;
			}

			int max = 0;
			int result = 0;
			for(int i = 0 ; i < 101; i++) {
				max = Math.max(max, score[i]);
				if(max == score[i]) {
					result = i;
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);

		}
	}

}
