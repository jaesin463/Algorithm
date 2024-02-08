import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] volt;
    static Integer[] dp;

    static int recur(int i){
        if(dp[i] == null){
            dp[i] = 1;

            for(int j = i + 1; j < dp.length; j++){
                if(volt[i][1] < volt[j][1])
                    dp[i] = Math.max(dp[i], recur(j) + 1);
            }
        }
        return dp[i];
    }

    static void solution() throws IOException{
        int max = 0;

        for(int i = 0; i < N; i++){
            max = Math.max(recur(i), max);
        }

        System.out.print(N - max);
    }

    static void make() throws IOException {
        N = init();
        volt = new int[N][2];
        dp = new Integer[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            volt[i][0] = init(st);
            volt[i][1] = init(st);
        }

        Arrays.sort(volt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    public static void main(String[] args) throws IOException{
        make();
        solution();
    }

    static int init() throws IOException{
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) throws IOException{
        return Integer.parseInt(st.nextToken());
    }
}