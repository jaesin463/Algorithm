import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void solution() throws IOException {
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            switch (init(st)){
                case 1 :
                    dq.offerFirst(init(st));
                    break;
                case 2 : dq.offerLast(init(st));
                    break;
                case 3 : sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
                    break;
                case 4 : sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
                    break;
                case 5 : sb.append(dq.size()).append("\n");
                    break;
                case 6 : sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7 : sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                    break;
                case 8 : sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    public static void make() throws IOException {
        N = init();
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