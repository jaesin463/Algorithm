import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] student;
	static int sum;
	static long cnt = 0;

	public static void three_student(int index) {
		int left = index + 1;
		int right = N - 1;
		while (left < right) {
			int rstudent = student[right];
			int lstudent = student[left];
			sum = student[index] + lstudent + rstudent;
			if (sum == 0) {
				if (rstudent == lstudent) {
					cnt += right - left;
					left++;
				}
				else {
					long rcnt = 0;
					while (student[right] == rstudent) {
						right--;
						rcnt++;
					}
					long lcnt = 0;
					while (student[left] == lstudent) {
						left++;
						lcnt++;
					}
					cnt += lcnt * rcnt;
				}
			}
			else if (sum > 0) {
				right--;
			} 
			else if(sum < 0){
				left++;
			}
		}

	}

	static void make() throws IOException {
		StringTokenizer st;
		N = init(br.readLine());
		student = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			student[i] = init(st.nextToken());
		}
		Arrays.sort(student);
		for (int idx = 0; idx < N - 2; idx++) {
			three_student(idx);
		}
	}

	public static void main(String[] args) throws IOException {
		make();
		System.out.println(cnt);
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}