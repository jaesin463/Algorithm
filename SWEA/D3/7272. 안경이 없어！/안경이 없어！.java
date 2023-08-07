import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();
			String str2 = st.nextToken();;

			int compare[] = new int[str.length()];
			
			String tf = "SAME";
			
			if(str.length()!=str2.length()) {
				System.out.printf("#%d DIFF\n",tc);
				continue;
			}
			
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'B') {
					compare[i] = 2;
				} else if(str.charAt(i) =='A' || str.charAt(i) =='D' || ((str.charAt(i) >= 79)&&(str.charAt(i) <=82))){
					compare[i] = 1;
				} else {
					compare[i] = 0;
				}
				
				if(str2.charAt(i) == 'B') {
					if(compare[i] != 2) {
						tf = "DIFF";
						break;
					}
				} else if(str2.charAt(i) =='A' || str2.charAt(i) =='D' || ((str2.charAt(i) >= 79)&&(str2.charAt(i) <=82))){
					if(compare[i] != 1) {
						tf = "DIFF";
						break;
					}
				} else {
					if(compare[i] != 0) {
						tf = "DIFF";
						break;
					}
				}
			}
			System.out.printf("#%d %s\n",tc, tf);

		}

	}
}
