import java.util.*;


class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();

            int[][] arr = new int[n][n];
            int[][] answer = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    answer[i][j] = Integer.MAX_VALUE;
                }
            }
            answer[0][0] = 0;

            for(int i = 0; i < n; i++) {
                String tmp = sc.next();
                for(int j = 0; j < n; j++) {
                    arr[i][j] = tmp.charAt(j) - '0';
                }
            }
            bfs(arr, answer, 0, 0, n);

            System.out.println("#" + test_case + " " + answer[n-1][n-1]);
        }
        sc.close();
    }
    static void bfs(int[][] arr, int[][] answer, int i, int j, int n) {
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        Queue<Integer> qi = new LinkedList<>();
        Queue<Integer> qj = new LinkedList<>();

        qi.add(i);
        qj.add(j);

        while (!qi.isEmpty() && !qj.isEmpty()) {
            Integer tmp_i = qi.remove();
            Integer tmp_j = qj.remove();

            for(int idx=0; idx<4; idx++) {
                int ni = tmp_i + di[idx];
                int nj = tmp_j + dj[idx];
                if (0 <= ni && ni < n && 0 <= nj && nj < n &&
                        answer[tmp_i][tmp_j] + arr[ni][nj] < answer[ni][nj]) {
                    qi.add(ni);
                    qj.add(nj);
                    answer[ni][nj] = answer[tmp_i][tmp_j] + arr[ni][nj];
                }
            }
        }
    }
}