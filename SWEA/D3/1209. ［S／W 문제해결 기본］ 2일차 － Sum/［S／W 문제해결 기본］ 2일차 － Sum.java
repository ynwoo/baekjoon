import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    static int n = 0;
    static int arr[][] = new int[100][100];
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int answer = Integer.MIN_VALUE;
            n = sc.nextInt();
            for(int i=0 ; i<100 ; i++) {
                for(int j=0 ; j<100 ; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 가로 합
            for (int i = 0 ; i < 100 ; i++) {
                int tmp = Arrays.stream(arr[i]).sum();
                if (answer < tmp) {
                    answer = tmp;
                }
            }
            // 세로 합
            for(int j=0 ; j < 100 ; j++) {
                int tmp = 0;
                for(int i=0 ; i < 100 ; i++) {
                    tmp += arr[i][j];
                }
                if (answer < tmp) {
                    answer = tmp;
                }
            }
            // 대각선 합
            int tmp = 0;
            for(int i=0 ; i < 100 ; i++) {
                tmp += arr[i][i];
            }
            if (answer < tmp) {
                answer = tmp;
            }

            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }
}