import java.util.*;


class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int div = 10007;
        int[][] arr = new int[n+1][n+1];
        for(int i=0; i < n+1; i++) {
            for(int j=0; j < n+1; j++) {
                arr[i][j] = 1;
            }
        }

        for(int i=2; i < n+1; i++) {
            for(int j=1; j < i; j++) {
                arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % div;
            }
        }

        System.out.println(arr[n][k]);
        sc.close();
    }
}