import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] out;
	static int[] numArr;
	static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = init(st.nextToken());
		M = init(st.nextToken());
		numArr = new int[N];
		visited = new boolean[N];
		out = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numArr);
		dfs(0);

	}

	public static void dfs(int cnt) {
		if(cnt == M){
            for(int i = 0; i<M; i++)
                System.out.print(out[i]+" ");
            System.out.println();
        }

        else{
            int before = 0;
            for(int i = 0; i<N; i++){
                if(visited[i])
                    continue;

                if(before != numArr[i]){
                    visited[i] = true;
                    out[cnt] = numArr[i];
                    before = numArr[i];
                    dfs(cnt+1);
                    visited[i] = false;
                }
            }
        }
	}

	static int init(String str) {
		return Integer.parseInt(str);
	}
}