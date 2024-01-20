import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st1;
    static StringTokenizer st2;
    static int N;
    static int[] lostLife, getHappy;
    static int[][] dp;

    public static void solution() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < 100; j++) {
                if (j >= lostLife[i])
                    dp[i][j] = Math.max(dp[i - 1][j - lostLife[i]] + getHappy[i], dp[i - 1][j]);
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][99]);
    }

    public static void make() throws IOException {
        N = init();
        lostLife = new int[N + 1];
        getHappy = new int[N + 1];
        dp = new int[N + 1][100];

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            lostLife[i] = init(st1);
            getHappy[i] = init(st2);
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