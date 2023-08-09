
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine() + " ";
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		boolean B = false;
		for(int i = 0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='<') {
				result.append(sb.reverse());
				sb.delete(0, sb.length());
				sb.append(ch);
				B = true;
			} else if(ch=='>') {
				sb.append(ch);
				result.append(sb);
				sb.delete(0, sb.length());
				B = false;
			} else if(ch==' ' && B) {
				sb.append(ch);
			} else if(ch==' ' && !B) {
				result.append(sb.reverse()).append(" ");
				sb.delete(0, sb.length());
			} else {
				sb.append(ch);
			}
		}
		System.out.println(result);
	}
	
	

}
