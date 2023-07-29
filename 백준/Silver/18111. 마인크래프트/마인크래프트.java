import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//전체 블록 구성 배열
	static int[][] mine;
	//초기 입력값
	static int row;
	static int col;
	static int block;
	//구성된 블럭의 최소 최대
	static int Min = Integer.MAX_VALUE;
	static int Max = Integer.MIN_VALUE;
	//블럭수 리셋
	static int invenB;
	
	static int time;
	static int maxHigh;
	static int minTime = Integer.MAX_VALUE;

	public static void search() {
		for (int j = 0; j < row; j++) {
			for (int k = 0; k < col; k++) {
				if (Min - mine[j][k] > 0) {
					plusB(j, k);
				} else if (Min - mine[j][k] < 0) {
					minusB(j, k);
				}
			}
		}
	}

	public static void plusB(int j, int k) {
		time += (Min - mine[j][k]);
		invenB -= (Min - mine[j][k]);
	}

	public static void minusB(int j, int k) {
		time += ((mine[j][k] - Min) * 2);
		invenB += (mine[j][k] - Min);
	}

	public static void vs() {
		if (invenB >= 0 && minTime > time) {
			minTime = time;
			maxHigh = Min;
		} else if (invenB >= 0 && minTime == time) {
			if (maxHigh < Min)
				maxHigh = Min;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		block = Integer.parseInt(st.nextToken());

		mine = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				mine[i][j] = Integer.parseInt(st.nextToken());
				Min = Math.min(Min, mine[i][j]);
				Max = Math.max(Max, mine[i][j]);
			}
		}

		for (; Min <= Max; Min++) {
			time = 0;
			invenB = block;

			search();
			vs();
		}

		System.out.println(minTime + " " + maxHigh);

	}
}