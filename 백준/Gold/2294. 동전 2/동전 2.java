import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] coin;
    static int[] dp;

    public static void solution() {
        dp = new int[K + 1];
        for (int i = 1; i <= K; i++)
            dp[i] = Integer.MAX_VALUE - 1;
        for (int i = 1; i <= N; i++)
            for (int j = coin[i]; j <= K; j++)
                dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);

        System.out.println(dp[K] == Integer.MAX_VALUE - 1 ? -1 : dp[K]);
    }

    static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = init(st);
        K = init(st);

        coin = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            coin[i] = init();
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