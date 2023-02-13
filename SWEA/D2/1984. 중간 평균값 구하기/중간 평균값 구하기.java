import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            double sum = 0;
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }

            System.out.println("#" + testCase + " " + (int) (sum / 8 + 0.5));
        }
        sc.close();
    }
}