import java.util.*;


class Solution
{
    static int answer = 0;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10, n = 100;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            int testCase = sc.nextInt();
            int[][] arr = new int[n][n];
            boolean[][] visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                String tmp = sc.next();
                for(int j = 0; j < n; j++) {
                    arr[i][j] = tmp.charAt(j) - '0';
                }
            }
            // 미로의 시작점 (1,1)
            bfs(arr, visited, 1, 1, n);

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (arr[i][j] == 3 && visited[i][j]) {
                        answer = 1;
                        break;
                    }
                }
            }
            System.out.println("#" + testCase + " " + answer);
        }
        sc.close();
    }
    static void bfs(int[][] arr, boolean[][] visited, int i, int j, int n) {
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        Queue<Integer> qi = new LinkedList<>();
        Queue<Integer> qj = new LinkedList<>();

        visited[i][j] = true;
        qi.add(i);
        qj.add(j);

        while (!qi.isEmpty() && !qj.isEmpty()) {
            Integer tmp_i = qi.remove();
            Integer tmp_j = qj.remove();

            for(int idx=0; idx<4; idx++) {
                int ni = tmp_i + di[idx];
                int nj = tmp_j + dj[idx];
                if (0 <= ni && ni < n && 0 <= nj && nj < n &&
                        arr[ni][nj] != 1 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    qi.add(ni);
                    qj.add(nj);
                }
            }
        }
    }
}