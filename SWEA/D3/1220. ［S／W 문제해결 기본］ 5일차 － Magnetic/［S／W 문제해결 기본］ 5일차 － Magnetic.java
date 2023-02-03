import java.util.*;


class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 1) {
                        for (int k = i; k < n; k++) {
                            if(arr[k][j] == 1 && k != i) {
                                break;
                            }
                            if(arr[k][j] == 2) {
                                answer++;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + testCase + " " + answer);
        }
        sc.close();
    }
}