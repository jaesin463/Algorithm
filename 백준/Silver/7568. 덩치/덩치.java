import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	테스트 케이스의 개수
	static int test_case;

	public static void main(String[] args) throws IOException {

		test_case = Integer.parseInt(br.readLine());

		int[][] kgcm = new int[test_case][2];
		int[] rank = new int[test_case];
		
		for(int i = 0; i < test_case; i++) {
			rank[i] = 1;
		}
		
		for (int i = 0; i < test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			kgcm[i][0] = Integer.parseInt(st.nextToken());						
			kgcm[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < test_case; i++) {
			for(int j = 0; j < test_case; j++) {
				if(kgcm[i][0] > kgcm[j][0]) {
					continue;
				}else if(kgcm[i][0] < kgcm[j][0] && kgcm[i][1] < kgcm[j][1]) {
					rank[i]++;
				}
			}
		}
		for(int i = 0; i < test_case; i++) {
			System.out.print(rank[i] + " ");
		}
	}
}