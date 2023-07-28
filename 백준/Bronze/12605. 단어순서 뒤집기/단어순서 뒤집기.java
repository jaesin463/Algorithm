import java.util.Scanner;
/*내가 이해한 next와 nextLine의 차이
 * next: \t, \n 등 띄어쓰기 혹은 개행의 전까지 입력을 받아서 개행문자들이 컴퓨터에 그대로 남아있음
 * nextLine : \t, \n 등의 개행문자를 포함하여 입력을 받아 컴퓨터에서 같이 사라짐
 * 
 * 그래서 time을 nextInt로 받으면 \n이 남아있어서 아래 for문에서 0번째 입력이 바로 끝나버리는 것
 * 해결방안1 : nextInt를 그대로 사용하려면 for문 이전에 nextLine을 통해서 남아있는 개행문자를 제거
 * 해결방안2 : 애초에 time을 nextLine을 통해 받아 개행문자를 남겨두지 않는 방법
 * 			대신 nextLine은  자료형을 String으로 반환하기 떄문에 정수형으로 형변환이 필요
 */

//해결방안 1 적용
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int time = Integer.parseInt(sc.nextLine());
		
		String[][] string = new String[time][];

		for(int i = 0; i < time; i++) {
			string[i] = sc.nextLine().split(" ");
		}
		
		for(int i = 0; i < time; i++) {
			System.out.printf("Case #%d: ", i + 1);
			for(int cnt = string[i].length - 1; cnt >= 0; cnt--) {
				System.out.print(string[i][cnt] + " ");
			}
			System.out.println();
		}
	}
}

//해결방안 2 적용
//public class Main {
//	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		
//		int time = sc.nextInt();
//				
//		String[][] string = new String[time][];
//		
//		sc.nextLine();
//		for(int i = 0; i < time; i++) {
//			string[i] = sc.nextLine().split(" ");
//		}
//		
//		for(int i = 0; i < time; i++) {
//			System.out.printf("Case #%d: ", i + 1);
//			for(int cnt = string[i].length - 1; cnt >= 0; cnt--) {
//				System.out.print(string[i][cnt] + " ");
//			}
//			System.out.println();
//		}
//	}
//}