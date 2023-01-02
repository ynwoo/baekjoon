import java.util.*;


class Solution
{
    static int answer = 0;
    static int[] company;
    static int[][] customers;
    static int[] home;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();

            answer = Integer.MAX_VALUE;
            int[] arr = new int[n];
            company = new int[2];
            customers = new int[n][2];
            home = new int[2];

            inputCoordinates(company, sc);
            inputCoordinates(home, sc);
            for(int i = 0; i < n; i++) {
                inputCoordinates(customers[i], sc);
                arr[i] = i;
            }

            permutations(arr, 0, n, n);

            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }
    static void permutations(int[] arr, int idx, int n, int r){
        if (idx == r) {
            int sum = 0;

            sum += distance(company, customers[arr[0]]);
            for(int i = 0; i < n-1; i++) {
                sum += distance(customers[arr[i]], customers[arr[i+1]]);
            }
            sum += distance(customers[arr[n-1]], home);

            if (sum < answer) {
                answer = sum;
            }
            return;
        }
        for(int i=idx; i<n; i++) {
            swap(arr,idx, i);
            permutations(arr, idx+1, n, r);
            swap(arr,idx, i);
        }
    }
    static void swap(int[] arr, int idx, int i) {
        int tmp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = tmp;
    }
    static void inputCoordinates(int[] arr, Scanner sc) {
        for(int i = 0; i < 2 ; i++) {
            arr[i] = sc.nextInt();
        }
    }
    static int distance(int[] A, int[] B){
        return (Math.abs(A[0] - B[0]) + Math.abs(A[1] - B[1]));
    }
}