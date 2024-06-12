import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, Min;
    static Point[] selectVirus;
    static int[][] lab;
    static ArrayList<Point> virus = new ArrayList<>();
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void make() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = init(st);
        M = init(st);

        lab = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = init(st);
                if (lab[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
    }

    static void solution() throws IOException {
        Min = Integer.MAX_VALUE;
        selectVirus = new Point[M];
        setVirus(0, 0);
    }

    static void setVirus(int depth, int idx) {
        if (depth == M) {
            calcSpread();
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            selectVirus[depth] = virus.get(i);
            setVirus(depth + 1, i + 1);
        }
    }

    static void calcSpread() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int day = 0;
        for (int i = 0; i < M; i++) {
            visited[selectVirus[i].x][selectVirus[i].y] = true;
            q.add(selectVirus[i]);
        }

        while (!q.isEmpty()) {
            if(day >= Min)
                return;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int dx = cur.x + delta[j][0];
                    int dy = cur.y + delta[j][1];

                    if (index(dx, dy) && !visited[dx][dy]) {
                        if (lab[dx][dy] != 1) {
                            visited[dx][dy] = true;
                            q.add(new Point(dx, dy));
                        }
                    }
                }
            }
            day++;
        }
        if (isAllSpread(visited)) {
            Min = Math.min(Min, day - 1);
        }
    }

    static boolean isAllSpread(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] != 1 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void result() {
        System.out.print(Min == Integer.MAX_VALUE ? -1 : Min);
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

    static boolean index(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < N;
    }
}