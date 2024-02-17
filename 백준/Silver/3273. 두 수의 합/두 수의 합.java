import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, X;
    static int[] num;

    public static void solution() {
        int cnt = 0;
        int l = 0;
        int r = N - 1;

        while(l < r){
            int sum = num[l] + num[r];
            if(sum == X){
                cnt++;
                r--;
            }
            else if(sum < X)
                l++;
            else r--;
        }

        System.out.print(cnt);
    }

    static void make() throws IOException {
        N = init();

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            num[i] = init(st);
        }

        X = init();
        Arrays.sort(num);
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