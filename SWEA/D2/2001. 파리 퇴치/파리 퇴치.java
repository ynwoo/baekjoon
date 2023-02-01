import java.util.*;


class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            int sum = 0;

            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    sum = 0;
                    for (int k = i; k < i + m; k++) {
                        for (int l = j; l < j + m; l++) {
                            sum += arr[k][l];
                        }
                    }
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
        sc.close();
    }

}