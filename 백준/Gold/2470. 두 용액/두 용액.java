import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int Min = Integer.MAX_VALUE;
	static int[] result = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		int[] liquid = new int[num];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = num - 1;
		Arrays.sort(liquid);

		int sum, abs;
				
		while (left < right) {
			sum = liquid[left] + liquid[right];
			abs = Math.abs(sum);
			if (abs < Min) {
				Min = abs;
				result[0] = liquid[left];
				result[1] = liquid[right];
			}
			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}

		bw.write(result[0] + " " + result[1]);
		bw.flush();
		bw.close();

	}
}