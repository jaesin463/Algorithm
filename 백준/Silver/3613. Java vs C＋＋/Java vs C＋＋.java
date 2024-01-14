import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static boolean isJava = false;
    static boolean allOfLower = true;

    public static boolean name_check() {
        int isUpperCase = 0;
        int isUnderBar = 0;

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch >= 'A' && ch <= 'Z') isUpperCase = 1;
            else if (ch == '_') isUnderBar = 1;
        }

        allOfLower = isUnderBar != 1 && isUpperCase != 1;

        // Java와 Cpp 형식을 혼용 했을때 false return
        if ((isUnderBar & isUpperCase) == 0 || allOfLower) {
            isJava = isUnderBar != 1;
            return true;
        } else return false;

    }

    public static boolean is_Cpp() {
        if (sb.charAt(sb.length() - 1) == '_') return false;
        else if (sb.charAt(0) == '_') return false;
        else return sb.indexOf("__") < 0;
    }

    public static boolean is_Java() {
        return sb.charAt(0) < 'A' || sb.charAt(0) > 'Z';
    }

    public static void javaToCpp() {
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.replace(i, i + 1, String.valueOf(ch).toLowerCase());
                sb.insert(i, "_");
            }
        }
    }

    public static void cppToJava() {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '_') {
                sb.deleteCharAt(i);
                sb.replace(i + 1, i + 1, String.valueOf(sb.charAt(i)).toUpperCase());
                sb.deleteCharAt(i);
            }
        }
    }

    public static void solution() {
        // Java, C++ 형식에 맞지 않을 경우
        if (!(is_Cpp() && is_Java() && name_check())) {
            System.out.println("Error!");
            return;
        }

        // 모든 문자가 소문자일 경우 그대로 return
        if (allOfLower) {
            System.out.println(sb);
            return;
        }

        // true = java, false = Cpp
        if (isJava) javaToCpp();
        else cppToJava();

        System.out.println(sb);
    }

    public static void make() throws IOException {
        sb = new StringBuilder(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        make();
        solution();
    }
}