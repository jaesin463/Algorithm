import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
        	arr[i] = sc.next();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
        	sb.append(arr[i]);
        }
        
        System.out.println(sb);
    }
}
