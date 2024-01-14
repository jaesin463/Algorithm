import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int max = 0;

    static int makeTable(String parent) {
        int n = parent.length();
        for (int pos = 0; pos < n; pos++) {
            String pattern = parent.substring(pos);
            int n2 = pattern.length();
            int[] table = new int[n2];
            int idx = 0;
            for (int i = 1; i < n2; i++) {
                while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                    idx = table[idx - 1];
                }
                if (pattern.charAt(i) == pattern.charAt(idx)) {
                    table[i] = ++idx;
                    max = Math.max(max, idx);
                }
            }
        }
        return max;
    }

    static void make() throws IOException {
        String parent = br.readLine();

        makeTable(parent);
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        make();
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}