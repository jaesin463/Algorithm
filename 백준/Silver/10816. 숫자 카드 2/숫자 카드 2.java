import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
 
			// upperBound와 lowerBound의 차이 값을 구한다.
			sb.append(upperBound(arr, target) - lowerBound(arr, target)).append(' ');
		}
		System.out.println(sb);
	}
 
	private static int lowerBound(int[] arr, int target) {
		int low = 0; 
		int high = arr.length; 
 
		// low가 high랑 같아질 때 까지 반복
		while (low < high) {
 
			int mid = (low + high) / 2; // 중간위치를 구한다.

			if (target <= arr[mid]) {
				high = mid;
			}
 
			else {
				low = mid + 1;
			}
 
		}
 
		return low;
	}
 
	private static int upperBound(int[] arr, int target) {
		int low = 0; 
		int high = arr.length; 
 
		// low가 high랑 같아질 때 까지 반복
		while (low < high) {
 
			int mid = (low + high) / 2; // 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if (target < arr[mid]) {
				high = mid;
			}
			// 중복원소의 경우 else에서 처리된다.
			else {
				low = mid + 1;
			}
 
		}
 
		return low;
	}
	
	
}