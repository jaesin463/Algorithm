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

		// 입력 값 할당
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		// N개의 요소를 가진 배열 생성
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		selectSort(num);
		
		System.out.println(num[N/2]);
	}

}
