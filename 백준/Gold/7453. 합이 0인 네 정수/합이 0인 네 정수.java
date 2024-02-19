import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long cnt;
    static long[][] num;
    static long[] ab;
    static long[] cd;

    static void findZero() {
        int l = 0;
        int r = ab.length - 1;

        while (l < ab.length && r >= 0) {
            long curAb = ab[l];
            long curCd = cd[r];
            long sum = curAb + curCd;

            if (sum > 0) {
                r--;
            } else if (sum < 0) {
                l++;
            } else {
                long cntL = 0, cntR = 0;
                while (l < ab.length && ab[l] == curAb) {
                    cntL++;
                    l++;
                }
                while (r >= 0 && cd[r] == curCd) {
                    cntR++;
                    r--;
                }
                cnt += cntL * cntR;
            }
        }
    }

    static void makeList() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab[N * i + j] = num[i][0] + num[j][1];
                cd[N * i + j] = num[i][2] + num[j][3];
            }
        }
    }

    public static void solution() {
        makeList();
        Arrays.sort(ab);
        Arrays.sort(cd);
        findZero();
        System.out.print(cnt);
    }

    static void make() throws IOException {
        N = init();
        num = new long[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                num[i][j] = init(st);
            }
        }

        ab = new long[N * N];
        cd = new long[N * N];
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