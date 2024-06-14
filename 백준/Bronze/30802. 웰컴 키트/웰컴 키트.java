import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, T, P;
    static int[] size;
    static int result = 0;

    static void make() throws IOException {
        N = init();

        size = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            size[i] = init(st);
        }

        st = new StringTokenizer(br.readLine());
        T = init(st);
        P = init(st);
    }

    static void solution() {
        for(int i = 0 ; i < 6; i++){
            int quot = size[i] / T;
            int mod = size[i] % T;
            result += mod != 0 ? quot + 1 : quot;
        }
        sb.append(result).append("\n");

        sb.append(N / P).append(" ").append(N % P);
    }

    static void result() {
        System.out.print(sb);
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