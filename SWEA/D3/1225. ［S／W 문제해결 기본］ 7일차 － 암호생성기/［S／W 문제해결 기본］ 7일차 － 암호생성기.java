import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	for (int tc = 1; tc <= 10; tc++) {
	    Queue<Integer> queue = new LinkedList<>();
	    br.readLine();
	    st = new StringTokenizer(br.readLine());

	    for (int i = 0; i < 8; i++) {
		queue.offer(init(st.nextToken()));
	    }

	    int minus = 1;
	    while (true) {
		int temp = queue.poll();
		temp -= minus++;
		if (minus == 6)
		    minus = 1;
		if (temp <= 0) {
		    temp = 0;
		    queue.offer(temp);
		    break;
		}
		else queue.offer(temp);
	    }
	    String result = queue.toString().replace(",", "").replace("[", "").replace("]", "");
	    System.out.printf("#%d %s\n", tc, result);
	}
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}