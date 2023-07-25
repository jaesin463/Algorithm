import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> si = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());

		int[] nArr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}

		si.push(0);
		int temp = 0;
		int idx = 1;
		
		Loop1 : while(idx != N){
			while (nArr[si.peek()] > nArr[idx]) {
				si.push(idx);
				idx++;
				if(idx == N) break Loop1;
			}
			while (!si.isEmpty()) {
				temp = si.pop();
				if (nArr[temp] < nArr[idx])
					nArr[temp] = nArr[idx];
				else if(nArr[temp] >= nArr[idx]) {
					si.push(temp);
					break;
				}
			}
						
			si.push(idx);
			idx++;
		}
		
		while (!si.isEmpty()) {
			nArr[si.pop()] = -1;
		}

		for(int i = 0; i < N; i++) {
			bw.write(nArr[i] + " ");
		}
				
		bw.flush();
		bw.close();
	}
}