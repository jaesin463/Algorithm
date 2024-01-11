import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] banner;
    static boolean[][] visited;
    static int nWord = 0;
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    static void grouping(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 8; i++) {
                int dr = now.x + delta[i][0];
                int dc = now.y + delta[i][1];

                if (index(dr, dc) && banner[dr][dc] == 1 && !visited[dr][dc]) {
                    q.offer(new Point(dr, dc));
                    visited[dr][dc] = true;
                }
            }
        }
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (banner[i][j] == 1 && !visited[i][j]) {
                    grouping(i, j);
                    nWord++;
                }
            }
        }
        System.out.println(nWord);
    }

    static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = init(st);
        M = init(st);

        banner = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                banner[i][j] = init(st);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
    }

    static boolean index(int r, int c) {
        return (r < N && r >= 0 && c < M && c >= 0);
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}