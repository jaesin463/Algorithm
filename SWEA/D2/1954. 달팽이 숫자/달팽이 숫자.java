import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
           int N = sc.nextInt();
 
        int rot = 1;
         
        int lu = 0;
        int rd = 1;
 
        int ex1 = N;
        int ex2 = N;
        int ex3 = 0;
        int ex4 = 1;
 
        int row = 0;
        int col = 0;
 
        int count = 1;
 
        boolean end = false;
 
        int[][] snail = new int[N][N];
         
 
        while (end == false) {
            switch (rot) {
            case 1:
                for (col = lu; col < ex1; col++) {
                    snail[row][col] = count++;
                }
                col--;
                ex1--;
                lu++;
                rot = 2;
                break;
            case 2:
                for (row = rd; row < ex2; row++) {
                    snail[row][col] = count++;
                }
                row--;
                ex2--;
                rd++;
                rot = 3;
                break;
            case 3:
                for (col = N - rd; col >= ex3; col--) {
                    snail[row][col] = count++;
                }
                col++;
                ex3++;
                rot = 4;
                break;
            case 4:
                for (row = N - lu - 1; row >= ex4; row--) {
                    snail[row][col] = count++;
                }
                row++;
                ex4++;
                rot = 1;
                break;
            }
            if (count > N * N) {
                end = true;
            }
        }
        System.out.println("#" + test_case);
        for(int i = 0; i<snail.length; i++) {
            for(int j =0; j<snail[i].length; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }
 
             
             
        }
    }
}