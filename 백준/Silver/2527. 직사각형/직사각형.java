import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int xaa = Integer.parseInt(st.nextToken());
			int yaa = Integer.parseInt(st.nextToken());
			int xab = Integer.parseInt(st.nextToken());
			int yab = Integer.parseInt(st.nextToken());
			int xba = Integer.parseInt(st.nextToken());
			int yba = Integer.parseInt(st.nextToken());
			int xbb = Integer.parseInt(st.nextToken());
			int ybb = Integer.parseInt(st.nextToken());
			
			if (xab < xba || yab < yba || xbb < xaa || ybb < yaa) {
				System.out.println("d");
			}
			else if ((xaa == xbb && yaa == ybb) || (xaa == xbb && yab == yba) || (xab == xba && yab == yba) || (xab == xba && yaa == ybb)) {
				System.out.println("c");
			}
			else if (xab == xba || yab == yba|| xbb == xaa || yaa == ybb){
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
	}
}
