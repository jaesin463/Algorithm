import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("2000\n");
		for(int i = 1; i <= 1000; i++) {
			bw.write("1 ");
		}
		for(int i = 1000; i >= 1; i--) {
			bw.write("1000 ");
		}
		bw.close();
	}
}