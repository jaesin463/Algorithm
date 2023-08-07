import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int mushroom = 0;
		
		for(int i = 0; i < 10; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(Math.abs(100-mushroom) >= Math.abs(100-mushroom-temp)) {
				mushroom += temp;
			}else {
				break;
			}
		}
		
		System.out.println(mushroom);
	}
}
