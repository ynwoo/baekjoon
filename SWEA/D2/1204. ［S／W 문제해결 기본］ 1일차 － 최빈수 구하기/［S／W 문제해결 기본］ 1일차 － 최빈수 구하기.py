import java.util.Scanner;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int t = sc.nextInt();
            int[] scoreCount = new int[101];
            int score, idx = 0, answer = 0;

            for(int i=0 ; i<1000 ; i++) {
                score = sc.nextInt();
                scoreCount[score]++;
            }
            for(int i=0 ; i<101 ; i++) {
                if (answer <= scoreCount[i]) {
                    answer = scoreCount[i];
                    idx = i;
                }
            }
            System.out.println("#" + t + " " + idx);
        }
        sc.close();
    }
}