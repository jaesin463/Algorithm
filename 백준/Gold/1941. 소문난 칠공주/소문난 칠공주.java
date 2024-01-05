import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] map;
    static int answer = 0;
    static boolean[] visited;
    static int[] selected = new int[7];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{selected[0] / 5, selected[0] % 5});
        visited[0] = true;
        int conn = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int ni = nr * 5 + nc; //0~24의 다음 index

                if (!index(nr, nc)) continue;

                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && selected[j] == ni) {
                        q.add(new int[]{nr, nc});
                        visited[j] = true;
                        conn++;
                    }
                }
            }
        }
        if (conn == 7) answer++;
    }

    static void solution(int depth, int numY, int start) {
        if (numY >= 4) return;

        if (depth == 7) {
            visited = new boolean[7];
            BFS();
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            if (map[i / 5][i % 5] == 'Y') {
                solution(depth + 1, numY + 1, i + 1);
            } else {
                solution(depth + 1, numY, i + 1);
            }

        }
    }

    static void make() throws IOException {
        map = new char[5][5];

        for (int r = 0; r < 5; r++) {
            map[r] = br.readLine().toCharArray();
        }

        solution(0, 0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        make();
    }

    static boolean index(int r, int c) { //r, c index가 유효한지
        if (r >= 0 && r < 5 && c >= 0 && c < 5) return true;
        return false;
    }

    static int init() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static int init(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

}