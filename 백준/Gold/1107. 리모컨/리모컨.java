import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {    
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int channel = Integer.parseInt(br.readLine());
        int xBtn = Integer.parseInt(br.readLine());
        
        boolean[] Btn = new boolean[10];
        if(xBtn == 0) {
        	if(String.valueOf(channel).length() <= Math.abs(channel - 100)) {
        		System.out.println(String.valueOf(channel).length());
        	}else {
        		System.out.println(Math.abs(channel - 100));
        	}
        	
        	return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < xBtn; i++) {
            Btn[Integer.parseInt(st.nextToken())] = true;
        }
        
        //모든 버튼이 고장 난 경우
        int result = Math.abs(channel - 100);
        
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            
            boolean isBreak = false;
            for(int j = 0; j < str.length(); j++) {
                if(Btn[str.charAt(j) - '0']) {
                    isBreak = true; 
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(channel - i) + str.length();
                result = Math.min(min, result);
            }
        }        
        System.out.println(result);
    }
}
