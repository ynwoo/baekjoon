import java.util.*;


class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int count369 = check369(i);
            if (count369 == 0) {
                System.out.print(i + " ");
            } else {
                for (int j = 0; j < count369; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            }
        }
        sc.close();
    }

    private static int check369(int num) {
        int cnt = 0;

        while (num != 0) {
            int tmp = num % 10;
            if(tmp == 3 || tmp == 6 || tmp == 9) {
                cnt++;
            }
            num /= 10;
        }

        return cnt;
    }
}