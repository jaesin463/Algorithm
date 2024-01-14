import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static boolean isJava = false;
    static boolean isLowerCase = true;

    public static boolean isCpp() {
        if (sb.charAt(sb.length() - 1) == '_') return false;
        else if (sb.charAt(0) == '_') return false;
        else return sb.indexOf("__") < 0;
    }

    public static boolean isJava() {
        return sb.charAt(0) < 'A' || sb.charAt(0) > 'Z';
    }

    public static boolean errorCheck() {
        int isUpperCase = 0;
        int isUnderBar = 0;

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch >= 'A' && ch <= 'Z') isUpperCase = 1;
            else if (ch == '_') isUnderBar = 1;
        }

        isLowerCase = isUnderBar != 1 && isUpperCase != 1;

        // Java와 Cpp 형식을 혼용 했을때 false return
        if ((isUnderBar & isUpperCase) == 0) {
            isJava = isUnderBar != 1;
            return true;
        } else return false;
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
        // 어느 형식에도 포함되지 않는 경우
        if (!(isCpp() && isJava() && errorCheck())) {
            System.out.println("Error!");
            return;
        }

        // 모든 문자가 소문자일 경우 그대로 return
        if (isLowerCase) {
            System.out.println(sb);
            return;
        }

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