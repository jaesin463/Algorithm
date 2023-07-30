import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[] onOff;
	static int nSwitch;

	public static void man() {
		int idx = Integer.parseInt(st.nextToken());
		for (int j = idx - 1; j < nSwitch; j += idx) {
			onOff[j] = !onOff[j];
		}
	}

	public static void woman() {
		int idx = Integer.parseInt(st.nextToken()) - 1;
		
		onOff[idx] = !onOff[idx];
		
		if (idx != 0 && idx != nSwitch - 1) {
			for (int j = 1; j < nSwitch / 2; j++) {
				if (idx - j < 0 || idx + j == nSwitch) {
					break;
				}
				if (onOff[idx - j] != onOff[idx + j])
					break;

				onOff[idx - j] = !onOff[idx - j];
				onOff[idx + j] = !onOff[idx + j];
	
			}
		}
	}

	public static void main(String[] args) throws IOException {
		nSwitch = Integer.parseInt(br.readLine());
		onOff = new boolean[nSwitch];

		st = new StringTokenizer(br.readLine());

		//초기 스위치 상태
		for (int i = 0; i < nSwitch; i++) {
			if (Integer.parseInt(st.nextToken()) == 1)
				onOff[i] = true;
			else
				onOff[i] = false;
		}
		
		//학생 수
		int nStudent = Integer.parseInt(br.readLine());
		
		//입력 값에 따른 연산 실행
		for (int i = 0; i < nStudent; i++) {
			st = new StringTokenizer(br.readLine());

			if (st.nextToken().equals("1"))
				man();
			else
				woman();
		}
		
		//출력 문 생성
		for (int i = 0; i < nSwitch; i++) {
			if (onOff[i] == true)
				sb.append("1");
			else
				sb.append("0");
			if( (i + 1) % 10 == 0) {
				sb.append("\n");
			}else sb.append(" ");
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
	}
}