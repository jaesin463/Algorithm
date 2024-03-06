import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] cost;
    static int[][] dp;

    public static void solution() throws IOException {
        dp = new int[N + 1][N + 1];

        dp[1][1] = cost[1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - j][i - j] + cost[j]);
            }
        }

        System.out.print(dp[N][N]);
    }

    static void make() throws IOException {
        N = init();
        cost = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            cost[i] = init(st);
        }
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}