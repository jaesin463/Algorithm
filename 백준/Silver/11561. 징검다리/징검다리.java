import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static long N;

    static long solution() {
        double d = ((Math.sqrt(1 + 8 * N)) - 1) / 2;
        long result = (long) Math.floor(d);
        return result;
    }

    public static void main(String[] args) throws IOException {
        T = init();
        while (T-- > 0) {
            N = initL();
            sb.append(solution()).append("\n");
        }
        System.out.println(sb);
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static long initL() throws IOException {
        return Long.parseLong(br.readLine());
    }
}