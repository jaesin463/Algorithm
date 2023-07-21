import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nNode = Integer.parseInt(br.readLine());

		int[][] node = new int[nNode][2];

		

		// node로 이루어진 2차원 배열 생성
		for (int i = 0; i < nNode; i++) {
			String[] str = br.readLine().split(" ");
			node[i][0] = Integer.parseInt(str[0]);
			node[i][1] = Integer.parseInt(str[1]);
		}
		
		//람다식을 이용한 정렬
		Arrays.sort(node, (node1,node2) -> {
			if(node1[0] == node2[0]) {
				return node1[1] - node2[1];
			}else {
				return node1[0] - node2[0];
			}
		});
		
		

//		선택 정렬 구현
//		int[][] temp = new int[2][2];
//		int index = 0;
//		for (int i = 0; i < nNode - 1; i++) {
//			temp[0][0] = node[i][0];
//			temp[0][1] = node[i][1];
//			index = i;
//			for (int j = i + 1; j < nNode; j++) {
//				if (temp[0][0] > node[j][0]) {
//					temp[0][0] = node[j][0];
//					temp[0][1] = node[j][1];
//					index = j;
//				} else if (temp[0][0] == node[j][0]) {
//					if (temp[0][1] > node[j][1]) {
//						temp[0][0] = node[j][0];
//						temp[0][1] = node[j][1];
//						index = j;
//					}
//				}
//			}
//			temp[1][0] = node[i][0];
//			temp[1][1] = node[i][1];
//
//			node[i][0] = temp[0][0];
//			node[i][1] = temp[0][1];
//
//			node[index][0] = temp[1][0];
//			node[index][1] = temp[1][1];
//
//		}

//		버블정렬 구현
//		int[][] temp = new int[1][1];
//		for (int i = 0; i < nNode - 1; i++) {
//			for (int j = i; j < nNode - 1; j++) {
//				if (node[j][0] > node[j + 1][0]) {
//					temp[0][0] = node[j][0];
//					node[j][0] = node[j + 1][0];
//					node[j + 1][0] = temp[0][0];
//
//					temp[0][0] = node[j][1];
//					node[j][1] = node[j + 1][1];
//					node[j + 1][1] = temp[0][0];
//				}
//			}
//		}
//
//		for (int i = 0; i < nNode - 1; i++) {
//			for (int j = i; j < nNode - 1; j++) {
//
//				if (node[j][0] == node[j + 1][0] && node[j][1] > node[j + 1][1]) {
//					temp[0][0] = node[j][0];
//					node[j][0] = node[j + 1][0];
//					node[j + 1][0] = temp[0][0];
//
//					temp[0][0] = node[j][1];
//					node[j][1] = node[j + 1][1];
//					node[j + 1][1] = temp[0][0];
//
//				}
//			}
//		}

		for (int i = 0; i < nNode; i++) {
			System.out.println(node[i][0] + " " + node[i][1]);
		}

	}
}