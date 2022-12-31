import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution
{
    static int[][] arr = new int[9][9];
    static int answer = 1;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 1;

            for(int i=0 ; i<9 ; i++) {
                for(int j=0 ; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 가로, 세로 판별
            for(int i=0 ; i < 9 ; i++) {
                Boolean[] checkHorizontal = new Boolean[9];
                Boolean[] checkVertical = new Boolean[9];

                for(int j=0 ; j < 9; j++) {
                    checkHorizontal[arr[i][j]-1] = true;
                    checkVertical[arr[j][i]-1] = true;
                }
                List<Boolean> checkHorizontalList = Arrays.asList(checkHorizontal);
                List<Boolean> checkVerticalList = Arrays.asList(checkVertical);

                if (checkHorizontalList.contains(null) || checkVerticalList.contains(null)) {
                    answer = 0;
                    break;
                }
            }
            // 3 x 3 판별
            for(int i = 0 ; i < 9; i+=3) {
                for(int j = 0 ; j < 9 ; j+=3) {
                    check3By3(i, j);
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }
    static void check3By3(int a, int b) {
        Boolean[] check3By3 = new Boolean[9];

        for(int i = a ; i < a + 3 ; i++) {
            for (int j = b; j < b + 3; j++) {
                check3By3[arr[i][j]-1] = true;
            }
        }
        List<Boolean> check3By3List = Arrays.asList(check3By3);

        if (check3By3List.contains(null)) {
            answer = 0;
        }
    }
}