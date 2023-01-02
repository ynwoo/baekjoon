import java.util.*;


class Solution
{
    static int answer = 0;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            permutations(arr, 0, n, n);

            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }
    static void permutations(int[] arr, int idx, int n, int r){
        if (idx == r) {
            int left = 0, right = 0;
            raisingWeight(arr, n, 0, left, right);
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
    static void raisingWeight(int[] arr, int n, int depth, int left, int right) {
        if (n == depth) {
            answer += 1;
            return;
        }
        left += arr[depth];
        raisingWeight(arr, n, depth+1, left, right);
        left -= arr[depth];
        if ( left >= right + arr[depth]) {
            right += arr[depth];
            raisingWeight(arr, n, depth+1, left, right);
        }
    }
}