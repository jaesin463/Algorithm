import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static long[] liquid;
	static long sum, abs;
	static long Min = Long.MAX_VALUE;
	static long[] result = new long[3];
	
	public static void three_liquid(int index) {
		int left = index + 1;
		int right = size - 1;
		while (left < right) {
			sum = liquid[left] + liquid[index] + liquid[right];
			abs = Math.abs(sum);
			if (abs < Min) {
				Min = abs;
				result[0] = liquid[index];
				result[1] = liquid[left];
				result[2] = liquid[right];
			}
			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		size = Integer.parseInt(br.readLine());
		liquid = new long[size];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquid);

		for (int idx = 0; idx < size - 2; idx++) {
			three_liquid(idx);
		}

		bw.write(result[0] + " " + result[1] + " " + result[2]);
		bw.flush();
		bw.close();

	}
}