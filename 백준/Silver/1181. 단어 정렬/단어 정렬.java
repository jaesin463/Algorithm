import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nWord = Integer.parseInt(br.readLine());
		String[] word =  new String[nWord];
		
		
		for(int i = 1; i <= nWord; i++) {
			word[i-1] = br.readLine();
		}
		
		Arrays.sort(word, (a, b) -> {
			return a.compareTo(b);
		});
		
		Arrays.sort(word, (a, b) -> {
			return a.length() - b.length();
		});

		System.out.println(word[0]);
		
		for(int i = 1; i < nWord; i++) {
			if(!word[i].equals(word[i-1]))
				System.out.println(word[i]);
		}
		
		
	}
}