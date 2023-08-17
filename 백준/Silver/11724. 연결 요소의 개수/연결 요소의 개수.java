import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	st = new StringTokenizer(br.readLine());
	int N = init(st.nextToken());
	int M = init(st.nextToken());
	A = new ArrayList[N + 1];
	visited = new boolean[N + 1];

	for (int i = 1; i < N + 1; i++) {
	    A[i] = new ArrayList<>();
	}

	for (int i = 0; i < M; i++) {
	    st = new StringTokenizer(br.readLine());
	    int u = init(st.nextToken());
	    int v = init(st.nextToken());
	    A[u].add(v);
	    A[v].add(u);
	}

	int count = 0;

	for (int i = 1; i < N + 1; i++) {
	    if (!visited[i]) {
		count++;
		DFS(i);
	    }
	}

	System.out.println(count);
    }

    static void DFS(int v) {
	if (visited[v]) {
	    return;
	}
	visited[v] = true;
	for (int i : A[v]) {
	    if (visited[i] == false) {
		DFS(i);
	    }
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}