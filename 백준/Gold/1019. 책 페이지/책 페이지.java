import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] cnt;
    static int start, end, digit;

    static void solution() {
        while (start <= end) {
            // 시작 페이지의 마지막 자리가 0이 될 때 까지 ++
            while (start % 10 != 0 && start <= end) {
                counting(start, digit);
                start++;
            }

            // 마지막 페이지의 마지막 자리가 9가 될 때 까지 --
            while (end % 10 != 9 && start <= end) {
                counting(end, digit);
                end--;
            }

            if (start > end) break;

            // 마지막 자릿수를 제거한다.
            start /= 10;
            end /= 10;

            // start ~ end 사이의 0 ~ 9 갯수를 모두 센다.
            // 현재 자릿수 만큼 곱해줘야한다.
            for (int i = 0; i < 10; ++i) {
                cnt[i] += (end - start + 1) * digit;
            }

            // 자릿수를 높인다.
            digit *= 10;
        }
    }

    private static void counting(int num, int digit) {
        while (num > 0) {
            cnt[num % 10] += digit;
            num /= 10;
        }
    }

    static void make() throws IOException {
        digit = 1;
        start = 1;
        end = init();

        cnt = new int[10];
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
        for (long i : cnt) {
            System.out.print(i + " ");
        }
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) throws IOException {
        return Integer.parseInt(st.nextToken());
    }
}