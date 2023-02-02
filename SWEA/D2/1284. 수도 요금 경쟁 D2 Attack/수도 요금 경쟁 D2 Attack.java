import java.util.*;


class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int testCase = 1; testCase <= T; testCase++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            int s = sc.nextInt();
            int w = sc.nextInt();

            int aCompany = p * w;
            int bCompany = q;
            if (w > r) {
                bCompany += (w - r) * s;
            }
            System.out.println("#" + testCase + " " + Math.min(aCompany, bCompany));
        }

        sc.close();
    }

}