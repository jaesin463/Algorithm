import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, W;
    static int[][] dp = new int[1002][1002];
    static int[][] event = new int[1002][2];

    static int recur(int depth, int car1, int car2) {
        if (depth > W)
            return 0;

        if (dp[car1][car2] != 0)
            return dp[car1][car2];

        int car1Move = recur(depth + 1, depth, car2) + distance(1, car1, depth);
        int car2Move = recur(depth + 1, car1, depth) + distance(2, car2, depth);

        return dp[car1][car2] = Math.min(car1Move, car2Move);
    }

    public static int distance(int car, int startIdx, int endIdx) {
        int[] start = getStartPosition(car, startIdx);

        return Math.abs(start[0] - event[endIdx][0]) +
                Math.abs(start[1] - event[endIdx][1]);
    }

    public static int[] getStartPosition(int car, int idx) {
        if (idx == 0) {
            if (car == 1)
                return new int[]{1, 1};
            return new int[]{N, N};
        }
        return event[idx];
    }

    static void solution() throws IOException {
        sb.append(recur(1, 0, 0)).append("\n");

        int car1 = 0, car2 = 0;
        for (int i = 1; i < W + 1; i++) {
            int distOne = distance(1, car1, i);

            if (dp[car1][car2] - distOne == dp[i][car2]) {
                car1 = i;
                sb.append(1).append("\n");
            } else {
                car2 = i;
                sb.append(2).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void make() throws IOException {
        N = init();
        W = init();

        for (int i = 1; i < W + 1; i++) {
            st = new StringTokenizer(br.readLine());
            event[i][0] = init(st);
            event[i][1] = init(st);
        }
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) throws IOException {
        return Integer.parseInt(st.nextToken());
    }
}