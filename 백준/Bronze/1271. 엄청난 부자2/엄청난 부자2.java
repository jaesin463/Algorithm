import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger all = new BigInteger(st.nextToken());
		BigInteger live = new BigInteger(st.nextToken());
			
		bw.write(all.divide(live) + "\n" + all.remainder(live));
		bw.flush();
		bw.close();

	}
}