import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> frula = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			frula.push(str.charAt(i));
			
			if(frula.size()>= bomb.length()) {
				boolean flag = true;
				
				for(int j=0; j<bomb.length(); j++) {
					if(frula.get(frula.size()-bomb.length()+j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=0; j<bomb.length(); j++) {
						frula.pop();
					}
				}
			}
			
		}
	
		for(Character c : frula) {
			sb.append(c);
		}
		
		if(sb.length()==0) {
			System.out.println("FRULA");
			return;
		}
		System.out.println(sb.toString());
	}
}