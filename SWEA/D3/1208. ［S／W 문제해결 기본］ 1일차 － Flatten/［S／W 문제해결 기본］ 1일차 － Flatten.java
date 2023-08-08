import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int x = arr[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (arr[j] <= x) {
				swap(arr, ++i, j);
			}
		}

		if (i + 1 != end) {
			swap(arr, i + 1, end);
		}

		return i + 1;
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			int[] block = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				block[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int  i = 0; i < dump; i++) {
				quickSort(block, 0, 99);
				if(block[0] == block[99]) break;
				block[0]++;
				block[99]--;
			}
			
			quickSort(block, 0, 99);
			System.out.printf("#%d %d\n", tc, (block[99] - block[0]));

		}
	}

}
