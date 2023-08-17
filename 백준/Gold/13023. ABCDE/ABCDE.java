import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	st = new StringTokenizer(br.readLine());
	N = init(st.nextToken());
	int M = init(st.nextToken());

	friends = new ArrayList[N];
	visited = new boolean[N];
	//friends 인접 리스트의 각 ArrayList 초기화
	for (int i = 0; i < N; i++) {
	    friends[i] = new ArrayList<Integer>();
	}
	//그래프 데이터 저장
	for (int i = 0; i < M; i++) {
	    st = new StringTokenizer(br.readLine());
	    int s = init(st.nextToken());
	    int e = init(st.nextToken());
	    friends[s].add(e);
	    friends[e].add(s);
	}
	//사람의 수만큼 반복
	for (int i = 0; i < N; i++) {
	    DFS(i, 1);
	    //만약 한번이라도 depth가 5인 관계가 나오면 더이상 볼 필요 없음
	    if (arrive)
		break;
	}
	System.out.println(arrive ? "1" : "0");

    }

    static void DFS(int now, int depth) {
	//깊이가 5가 되었거나, 이미 결과를 얻은 상태거나
	if (depth == 5 || arrive) {
	    arrive = true;
	    return;
	}
	//현재 노드 방문 처리
	visited[now] = true;
	//현재 노드의 인접 노드들을 방문
	for (int i : friends[now]) {
	    //아직 방문 하지 않은 노드이면
	    if (!visited[i]) {
		//방문한다
		DFS(i, depth + 1);
	    }
	}
	//사람 수 만큼 반복해야 하므로 현재 노드의 방문이 모두 끝난 후 다시 미방문 처리
	visited[now] = false;
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}