import java.util.*;


class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int answer = 0;
            char[] c = sc.next().toCharArray();
            char[] zero = new char[c.length];
            for (int i = 0; i < c.length; i++) {
                zero[i] = '0';
            }

            for (int i = 0; i < c.length; i++) {
                if (zero[i] == c[i]) {
                    continue;
                }
                if (c[i] == '1') {

                    for (int j = i; j < c.length; j++) {
                        // zero i부터 끝까지 1로 변경
                        zero[j] = '1';
                    }
                    answer++;
                } else if (c[i] == '0') {

                    for (int j = i; j < c.length; j++) {
                        // zero i부터 끝까지 0으로 변경
                        zero[j] = '0';
                    }
                    answer++;
                }
            }

            System.out.println("#" + testCase + " " + answer);
        }
        sc.close();
    }
}