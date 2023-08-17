import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	N = init(br.readLine());

	// 일의 자리가 소수인 경우는 4가지 밖에 없다
	// 즉 신기한 소수가 되기 위해서는 맨 앞자리에는 이 수들만 가능하다
	DFS(2, 1);
	DFS(3, 1);
	DFS(5, 1);
	DFS(7, 1);
    }

    static void DFS(int num, int len) {
	if (len == N) {
	    if (isPrime(num)) {
		System.out.println(num);
	    }
	    return;
	}
	for (int i = 1; i < 10; i++) {
	    if (i % 2 == 0) {
		continue;
	    }
	    if (isPrime(num * 10 + i)) {
		DFS(num * 10 + i, len + 1);
	    }
	}
    }

    static boolean isPrime(int num) {
	for (int i = 2; i <= Math.sqrt(num); i++)
	    if (num % i == 0)
		return false;
	return true;
    }

    static int init(String str) {
	return Integer.parseInt(str);
    }
}