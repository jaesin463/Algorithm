import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
				
		long num = Integer.parseInt(br.readLine());
		
		sb.append(((1 + num + 3*(num*(num+1)) /2) % 45678));
		
		bw.write(String.valueOf(((1 + num + 3*(num*(num+1)) /2) % 45678)));
		bw.flush();
		
	}
}