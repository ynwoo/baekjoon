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
            int n, m;
            int[] A, B;
            int max, tmp;
            n = sc.nextInt();
            m = sc.nextInt();
            A = new int[n];
            B = new int[m];
            
            for(int i=0 ; i<n ; i++) {
                A[i] = sc.nextInt();
            }
            for(int i=0 ; i<m ; i++) {
                B[i] = sc.nextInt();
            }

            max = A[0] * B[0] + A[1] * B[1] + A[2] * B[2];
            if (n <= m) {
                for(int i=0 ; i <= m-n ; i++) {
                    tmp = 0;
                    for (int j=0 ; j < n ; j++) {
                        tmp += (A[j] * B[i+j]);
                    }

                    if (max < tmp) {
                        max = tmp;
                    }
                }
            } else {
                for(int i=0 ; i <= n-m ; i++) {
                    tmp = 0;
                    for (int j=0 ; j < m ; j++) {
                        tmp += (A[i+j] * B[j]);
                    }

                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
        sc.close();
    }
}