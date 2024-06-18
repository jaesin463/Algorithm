import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, c;
    static int[] house;

    static void make() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = init(st);
        c = init(st);

        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = init();
        }
    }

    static void solution() {
        Arrays.sort(house);

        int lo = 1;
        int hi = house[n - 1];

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int position = 0;
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (house[i] - house[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

            if (cnt < c) {
                hi = mid - 1;
                continue;
            }

            lo = mid + 1;
        }

        sb.append(lo - 1);
    }

    static void result() throws IOException {
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
        result();
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}