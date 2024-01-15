import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static char[][] miro;
    static List<int[]> hole = new ArrayList<>();
    static int[][] delta = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void DFS(int[] now, int[] end) {
        if (now[0] == end[0] && now[1] == end[1]) {
            miro[now[0]][now[1]] = '.';

            for (int i = 0; i < N; i++) {
                sb.append(miro[i]).append("\n");
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dr = now[0] + delta[i][0];
            int dc = now[1] + delta[i][1];

            if(index(dr,dc) && miro[dr][dc] == '@'){
                miro[dr][dc] = '.';
                DFS(new int[]{dr, dc}, end);
                miro[dr][dc] = '@';
            }
        }
    }

    public static void solution() throws IOException {
        miro[hole.get(0)[0]][hole.get(0)[1]] = '.';
        DFS(hole.get(0), hole.get(1));
        System.out.print(sb);
    }

    public static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = init(st);
        M = init(st);

        miro = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = (str.charAt(j) == '.') ? '@' : '+';
            }
        }

        for (int i = 0; i < M; i++) {
            if (miro[0][i] == '@')
                hole.add(new int[]{0, i});
            if (miro[N - 1][i] == '@')
                hole.add(new int[]{N - 1, i});
        }

        for (int i = 1; i < N - 1; i++) {
            if (miro[i][0] == '@')
                hole.add(new int[]{i, 0});
            if (miro[i][M - 1] == '@')
                hole.add(new int[]{i, M - 1});
        }
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
    }

    static boolean index(int r, int c){
        return (r < N && r >= 0 && c < M && c >= 0);
    }
    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}