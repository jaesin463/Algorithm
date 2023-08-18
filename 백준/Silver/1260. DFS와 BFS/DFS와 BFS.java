import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] Graph;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	st = new StringTokenizer(br.readLine());

	int node = init(st.nextToken());
	int edge = init(st.nextToken());
	int start = init(st.nextToken());

	Graph = new ArrayList[node + 1];

	for (int i = 1; i < node + 1; i++) {
	    Graph[i] = new ArrayList<Integer>();
	}

	for (int i = 0; i < edge; i++) {
	    st = new StringTokenizer(br.readLine());
	    int s = init(st.nextToken());
	    int e = init(st.nextToken());
	    Graph[s].add(e);
	    Graph[e].add(s);
	}

	for (int i = 1; i < node + 1; i++) {
	    Collections.sort(Graph[i]);
	}
	visited = new boolean[node + 1];
	DFS(start);
	System.out.println();
	
	visited = new boolean[node + 1];
	BFS(start);
    }

    static void DFS(int node) {
	System.out.print(node + " ");
	visited[node] = true;
	for (int i : Graph[node])
	    if (!visited[i])
		DFS(i);
    }

    static void BFS(int node) {
	Queue<Integer> queue = new LinkedList<>();
	queue.add(node);
	visited[node] = true;
	
	while(!queue.isEmpty()) {
	    int now = queue.poll();
	    System.out.print(now + " ");
	    for(int i : Graph[now])
		if(!visited[i]) {
		    visited[i] = true;
		    queue.add(i);
		}
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}