import java.io.*;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] minSegment, maxSegment, num;
    static int N, M;
    static int min, max;

    static void makeMaxSegment(int[] tree, int start, int end, int node) {
        int leftNode = (node << 1);
        int rightNode = (node << 1) + 1;

        if (start == end)
            tree[node] = num[start];
        else {
            int mid = start + (end - start) / 2;
            makeMaxSegment(tree, start, mid, leftNode);
            makeMaxSegment(tree, mid + 1, end, rightNode);

            tree[node] = Math.max(tree[leftNode], tree[rightNode]);
        }
    }

    static void makeMinSegment(int[] tree, int start, int end, int node) {
        int leftNode = (node << 1);
        int rightNode = (node << 1) + 1;

        if (start == end)
            tree[node] = num[start];
        else {
            int mid = start + (end - start) / 2;
            makeMinSegment(tree, start, mid, leftNode);
            makeMinSegment(tree, mid + 1, end, rightNode);

            tree[node] = Math.min(tree[leftNode], tree[rightNode]);
        }
    }

    static void findMaxValue(int start, int end, int node, int left, int right) {
        if (left > end || right < start)
            return;
        if (left <= start && end <= right) {
            max = Math.max(max, maxSegment[node]);
            return;
        }
        int mid = start + (end - start) / 2;
        findMaxValue(start, mid, (node << 1), left, right);
        findMaxValue(mid + 1, end, (node << 1) + 1, left, right);
    }

    static void findMinValue(int start, int end, int node, int left, int right) {
        if (left > end || right < start)
            return;
        if (left <= start && end <= right) {
            min = Math.min(min, minSegment[node]);
            return;
        }

        int mid = start + (end - start) / 2;
        findMinValue(start, mid, (node << 1), left, right);
        findMinValue(mid + 1, end, (node << 1) + 1, left, right);
    }

    public static void solution() throws IOException {
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = init(st);
            b = init(st);
            max = -1;
            min = (int) 1e9;
            findMinValue(1, N, 1, a, b);
            findMaxValue(1, N, 1, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    public static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = init(st);
        M = init(st);

        num = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            num[i] = init();
        }

        int treeSize = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        treeSize = (int) Math.pow(2, treeSize);

        maxSegment = new int[treeSize];
        minSegment = new int[treeSize];

        makeMinSegment(minSegment, 1, N, 1);
        makeMaxSegment(maxSegment, 1, N, 1);
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