import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K;
    static long[] segment, arr;

    public static void solution() throws IOException {
        for (int i = 0; i < M + K; i++) {
            if (M == 0 && K == 0)
                break;

            st = new StringTokenizer(br.readLine());
            int type = init(st);

            if (type == 1) {
                int numIdx = init(st);
                long num = Long.parseLong(st.nextToken());

                long diff = num - arr[numIdx];
                arr[numIdx] = num;

                updateSegment(1, N, 1, numIdx, diff);
            } else {
                int startIdx = init(st);
                int endIdx = init(st);

                sb.append(getSegment(1, N, 1, startIdx, endIdx)).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void updateSegment(int start, int end, int node, int numIdx, long diff) {
        if (start <= numIdx && numIdx <= end)
            segment[node] += diff;
        else return;

        if (start == end)
            return;

        int mid = (start + end) / 2;
        updateSegment(start, mid, node * 2, numIdx, diff);
        updateSegment(mid + 1, end, node * 2 + 1, numIdx, diff);
    }

    private static long getSegment(int start, int end, int node, int startIdx, int endIdx) {
        if (endIdx < start || end < startIdx)
            return 0;

        if (startIdx <= start && end <= endIdx)
            return segment[node];

        int mid = (start + end) / 2;
        return getSegment(start, mid, node * 2, startIdx, endIdx)
                + getSegment(mid + 1, end, node * 2 + 1, startIdx, endIdx);
    }

    public static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = init(st);
        M = init(st);
        K = init(st);

        segment = new long[getTreeSize()];
        arr = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        makeSegment(1, N, 1);
    }

    static int getTreeSize() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    static long makeSegment(int start, int end, int node) {
        if (start == end)
            return segment[node] = arr[start];

        int mid = (start + end) / 2;
        return segment[node] = makeSegment(start, mid, node * 2) + makeSegment(mid + 1, end, node * 2 + 1);
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