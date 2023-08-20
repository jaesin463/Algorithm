import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

public class Solution {
    static int[] stick = new int[100000];
    static int idx = 0;

    public static void laser() {
	for (int i = 0; stick[i] != 0; i++) {
	    stick[i] += 1;
	}
    }

    public static int endStick() {
	int end = stick[idx - 1];
	stick[--idx] = 0;
	return end;
    }

    public static int rEndStick() {
	return stick[idx - 1];
    }

    public static void startStick() {
	stick[idx++] = 1;
    }

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int test_case = Integer.parseInt(br.readLine());

	for (int tc = 1; tc <= test_case; tc++) {

	    char temp1;
	    char temp2;
	    int count = 0;
	    int index = 0;
	    String temp = br.readLine();
	    char[] ch = new char[temp.length() + 1];
	    for (int i = 0; i < temp.length(); i++) {
		ch[i] = temp.charAt(i);
	    }

	    ch[temp.length()] = '4';

	    while (index != temp.length() - 1) {
		temp1 = ch[index];
		temp2 = ch[index + 1];

		if (temp2 == '4') {
		    count += rEndStick();
		} else if (temp1 == '(' && temp2 == ')') {
		    laser();
		} else if (temp1 == ')' && temp2 == ')') {
		    count += endStick();
		} else if (temp1 == '(' && temp2 == '(') {
		    startStick();
		}
		index++;
	    }

	    System.out.printf("#%d %d\n", tc, count);

	}
    }
}