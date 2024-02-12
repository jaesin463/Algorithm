import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static long N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long res = N;
        for (long k = 2; k <= Math.sqrt(N); k++) {
            if (N % k == 0) {
                res = res - res / k;
                while (N % k == 0) N /= k;
            }
        }

        if (N > 1) res = res - res / N;
        System.out.println(res);
    }
}