import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int[][] dp = new int[A.length + 1][B.length + 1];
        char[][] cdp = new char[A.length + 1][B.length + 1];
        for (int i = 0; i <= A.length; i++) {
            Arrays.fill(cdp[i], ' ');
        }

        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    cdp[i][j] = A[i - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    if (dp[i][j - 1] <= dp[i - 1][j]) {

                        cdp[i][j] = cdp[i - 1][j];
                    } else {

                        cdp[i][j] = cdp[i][j - 1];
                    }
                }
            }
        }

        System.out.println(dp[A.length][B.length]);

        int i = A.length;
        int j = B.length;
        Stack<Character> stack = new Stack<>();
        while (i >= 1 && j >= 1) {
            if (dp[i][j] == dp[i - 1][j])
                i--;
            else if (dp[i][j] == dp[i][j - 1])
                j--;
            else {
                stack.push(B[j-1]);
                i--;
                j--;
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

}