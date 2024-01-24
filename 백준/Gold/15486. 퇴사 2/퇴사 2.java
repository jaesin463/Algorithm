import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] time, money, dp;
    static boolean[] isStack;

    public static void solution() {
        dp = new int[N + 2];

        int max = 0;
        for (int i = 1; i < N + 2; i++) {
            max = Math.max(max, dp[i]);
            if (i + time[i] > N + 1)
                continue;
            dp[i + time[i]] = Math.max(dp[i + time[i]], max + money[i]);
        }

        System.out.print(max);
    }

    public static void make() throws IOException {
        N = init();
        time = new int[N + 2];
        money = new int[N + 2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = init(st);
            money[i] = init(st);
        }
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
    }

    public static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}