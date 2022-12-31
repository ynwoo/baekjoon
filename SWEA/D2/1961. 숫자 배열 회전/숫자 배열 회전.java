import java.util.Scanner;

class Solution
{
    static int n = 0;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            int[][] arr = new int[n][n];

            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            rotate90degree(arr);
            int[][] arr90 = copyArray(arr);

            rotate90degree(arr);
            int[][] arr180 = copyArray(arr);

            rotate90degree(arr);
            int[][] arr270 = copyArray(arr);

            // 출력
            System.out.println("#" + test_case);
            for(int i = 0 ; i < n ; i++) {
                print(arr90, i);
                print(arr180, i);
                print(arr270, i);
                System.out.println();
            }
        }
        sc.close();
    }
    static void rotate90degree(int[][] arr) {
        for (int i = 0 ; i < n/2 ; i++) {
            for (int j = 0 ; j < n ; j++) {
                swap(arr, i,j, n-1-i,j);
            }
        }

        for (int i = 0 ; i < n-1 ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                swap(arr, i,j, j,i);
            }
        }
    }
    static void swap(int[][] arr, int ai, int aj, int bi, int bj) {
        int tmp = arr[ai][aj];
        arr[ai][aj] = arr[bi][bj];
        arr[bi][bj] = tmp;
    }

    static int[][] copyArray(int[][] arr) {
        int[][] newArr = new int[n][n];
        for(int i=0 ; i < n; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;
    }
    static void print(int[][] arr, int i) {
        for (int j = 0 ; j < n ; j++) {
            System.out.print(arr[i][j]);
        }
        System.out.print(" ");
    }
}