import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String jaeHwan = br.readLine();
		String Doctor = br.readLine();
		
		if(jaeHwan.length() >= Doctor.length()) bw.write("go");
		else bw.write("no");
		bw.flush();
		bw.close();

	}
}