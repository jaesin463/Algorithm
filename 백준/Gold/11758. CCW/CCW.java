import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] point = new int[4][2];
	
	static int ccw() {
		int a = point[1][0] * point[2][1] + point[2][0] * point[3][1] + point[3][0] * point[1][1]; 
		int b = point[1][1] * point[2][0] + point[2][1] * point[3][0] + point[3][1] * point[1][0];
		
		if(a > b) {
			return 1;
		} else if(a == b) {
			return 0;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		
		for(int i = 1; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = init(st.nextToken());
			point[i][1] = init(st.nextToken());
		}
		
		System.out.println(ccw());
		
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}