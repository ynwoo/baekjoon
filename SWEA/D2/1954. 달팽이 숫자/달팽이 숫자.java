import java.util.*;


class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int cnt = 1;
            int[][] arr = new int[n][n];
            System.out.println("#" + test_case);
            int i = 0, j = 0;
            arr[i][j] = cnt;
            // 출력
            while (cnt != n * n) {
                while (j + 1 < n && arr[i][j + 1] == 0) {
                    j++;
                    arr[i][j] = ++cnt;
                }
                while (i + 1 < n && arr[i + 1][j] == 0) {
                    i++;
                    arr[i][j] = ++cnt;
                }
                while (j - 1 >= 0 && arr[i][j - 1] == 0) {
                    j--;
                    arr[i][j] = ++cnt;
                }
                while (i - 1 >= 0 && arr[i - 1][j] == 0) {
                    i--;
                    arr[i][j] = ++cnt;
                }
            }
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    System.out.print(arr[k][l] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }

}