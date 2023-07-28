import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int array_num = Integer.parseInt(st.nextToken());
		int vs = Integer.parseInt(st.nextToken());

		int array[] = new int[array_num];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < array_num; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			if (array[i] < vs) {
				System.out.print(array[i] + " ");
			}
		}
	}
}