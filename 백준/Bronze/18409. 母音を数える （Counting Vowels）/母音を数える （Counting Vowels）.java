import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = init(br.readLine());
        String str = br.readLine();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            switch (str.charAt(i)) {
                case 'a': case 'i': case 'u': case 'e': case 'o':
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
    static int init(String str){
        return Integer.parseInt(str);
    }    
    
}