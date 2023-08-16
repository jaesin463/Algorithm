import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	int N = init(br.readLine());

	String[] num = br.readLine().split(" ");
	
	Arrays.sort(num, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));
	String result = Arrays.toString(num).replace(", ","").replace("[", "").replace("]", "");
	if(result.charAt(0)=='0') result = "0";
	System.out.println(result);
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}
