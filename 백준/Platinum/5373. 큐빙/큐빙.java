import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N = 3;
	static char[][] up = new char[3][3];
	static char[][] down = new char[3][3];
	static char[][] front = new char[3][3];
	static char[][] back = new char[3][3];
	static char[][] left = new char[3][3];
	static char[][] right = new char[3][3];

	static void upRotate(char direction) {
		char[] tempB = back[0].clone();
		if (direction == '+') {
			up = clockWise(up);

			back[0] = left[0].clone();

			left[0] = front[0].clone();

			front[0] = right[0].clone();

			right[0] = tempB;
		} else if (direction == '-') {
			up = counterClockWise(up);

			back[0] = right[0].clone();

			right[0] = front[0].clone();

			front[0] = left[0].clone();

			left[0] = tempB;
		}
	}

	static void downRotate(char direction) {
		char[] tempB = back[2].clone();
		if (direction == '+') {
			down = clockWise(down);
			back[2] = right[2].clone();

			right[2] = front[2].clone();

			front[2] = left[2].clone();

			left[2] = tempB;

		} else if (direction == '-') {
			down = counterClockWise(down);
			
			back[2] = left[2].clone();

			left[2] = front[2].clone();

			front[2] = right[2].clone();

			right[2] = tempB;
		}
	}

	static void frontRotate(char direction) {
		char[] tempU = { up[2][0], up[2][1], up[2][2] };
		if (direction == '+') {
			front = clockWise(front);
			for (int i = 0; i < 3; i++) {
				up[2][i] = left[2 - i][2];
			}

			for (int i = 0; i < 3; i++) {
				left[i][2] = down[2][2 - i];
			}

			for (int i = 0; i < 3; i++) {
				down[2][i] = right[i][0];
			}

			for (int i = 0; i < 3; i++) {
				right[i][0] = tempU[i];
			}
		} else if (direction == '-') {
			front = counterClockWise(front);

			for (int i = 0; i < 3; i++) {
				up[2][i] = right[i][0];
			}

			for (int i = 0; i < 3; i++) {
				right[i][0] = down[2][i];
			}

			for (int i = 0; i < 3; i++) {
				down[2][i] = left[2 - i][2];
			}

			for (int i = 0; i < 3; i++) {
				left[i][2] = tempU[2 - i];
			}
		}
	}

	static void backRotate(char direction) {
		char[] tempU = { up[0][2], up[0][1], up[0][0] };
		if (direction == '+') {
			back = clockWise(back);

			for (int i = 0; i < 3; i++) {
				up[0][i] = right[i][2];
			}
			for (int i = 0; i < 3; i++) {
				right[i][2] = down[0][i];
			}
			for (int i = 0; i < 3; i++) {
				down[0][i] = left[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				left[i][0] = tempU[i];
			}
		} else if (direction == '-') {
			back = counterClockWise(back);

			for (int i = 0; i < 3; i++) {
				up[0][i] = left[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				left[i][0] = down[0][2 - i];
			}
			for (int i = 0; i < 3; i++) {
				down[0][i] = right[i][2];
			}
			for (int i = 0; i < 3; i++) {
				right[i][2] = tempU[2 - i];
			}
		}
	}

	static void leftRotate(char direction) {
		char[] tempU = { up[0][0], up[1][0], up[2][0] };
		if (direction == '+') {
			left = clockWise(left);
			
			for (int i = 0; i < 3; i++) {
				up[i][0] = back[2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				back[i][2] = down[i][2];
			}
			for (int i = 0; i < 3; i++) {
				down[i][2] = front[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				front[i][0] = tempU[i];
			}
		} else if (direction == '-') {
			left = counterClockWise(left);

			for (int i = 0; i < 3; i++) {
				up[i][0] = front[i][0];
			}
			for (int i = 0; i < 3; i++) {
				front[i][0] = down[2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				down[i][2] = back[i][2];
			}
			for (int i = 0; i < 3; i++) {
				back[i][2] = tempU[2 - i];
			}
		}
	}

	static void rightRotate(char direction) {
		char[] tempU = { up[0][2], up[1][2], up[2][2] };
		if (direction == '+') {
			right = clockWise(right);

			for(int i=0;i<3;i++) {
				up[i][2] = front[i][2];
			}
			for(int i=0;i<3;i++) {
				front[i][2] = down[2-i][0];
			}
			for(int i=0;i<3;i++) {
				down[i][0] = back[i][0];
			}
			for(int i=0;i<3;i++) {
				back[i][0] = tempU[2 - i];
			}

		} else if (direction == '-') {
			right = counterClockWise(right);

			for(int i=0;i<3;i++) {
				up[i][2] = back[2-i][0];
			}
			for(int i=0;i<3;i++) {
				back[i][0] = down[i][0];
			}
			for(int i=0;i<3;i++) {
				down[i][0] = front[2-i][2];
			}
			for(int i=0;i<3;i++) {
				front[i][2] = tempU[i];
			}
		}
	}

	static char[][] clockWise(char[][] arr) {
		char[][] temp = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[N - j - 1][i];
			}
		}
		return temp;
	}
	
	static char[][] counterClockWise(char[][] arr) {
		char[][] temp = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[j][N - i - 1];
			}
		}
		return temp;
	}
	
	static void makeBoard() throws IOException {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				up[i][j] = 'w';
				down[i][j] = 'y';
				front[i][j] = 'r';
				back[i][j] = 'o';
				left[i][j] = 'g';
				right[i][j] = 'b';
			}
		}
	}

	static void rotate() throws IOException {
		int R = init(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			String oper = st.nextToken();
			char loc = oper.charAt(0);
			char direc = oper.charAt(1);
			if (loc == 'U') {
				upRotate(direc);
			} else if (loc == 'D') {
				downRotate(direc);
			} else if (loc == 'F') {
				frontRotate(direc);
			} else if (loc == 'B') {
				backRotate(direc);
			} else if (loc == 'L') {
				leftRotate(direc);
			} else if (loc == 'R') {
				rightRotate(direc);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int test_case = init(br.readLine());
		for (int tc = 1; tc <= test_case; tc++) {
			makeBoard();
			rotate();
			check(up);
		}
		System.out.println(sb.toString());
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}

	static int init(char c) {
		return c - '0';
	}

	static void check(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void check(char[][] arr) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
	}
}