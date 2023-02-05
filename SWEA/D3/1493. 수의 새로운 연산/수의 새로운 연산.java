import java.util.*;


class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int answer = 1;
            int p = sc.nextInt();
            int q = sc.nextInt();

            int[] pPosition = getPosition(p);
            int[] qPosition = getPosition(q);

            int newX = pPosition[0] + qPosition[0];
            int newY = pPosition[1] + qPosition[1];

            int x = 1, y = 1;
            int y_cnt = 1;
            while (newX != x || newY != y) {
                if (y - 1 == 0) {
                    x = 1;
                    y = ++y_cnt;
                } else {
                    y--;
                    x++;
                }
                answer++;
            }
            System.out.println("#" + testCase + " " + answer);
        }
        sc.close();
    }

    private static int[] getPosition(int n) {
        int[] result = new int[2];
        int x = 1, y = 1;
        int y_cnt = 1;
        for (int i = 2; i <= n; i++) {
            if (y - 1 == 0) {
                x = 1;
                y = ++y_cnt;
            } else {
                y--;
                x++;
            }
        }
        result[0] = x;
        result[1] = y;
        return result;
    }
}