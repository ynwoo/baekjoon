import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][N + 1]; // dp[i][j] : 길이가 i이고 j부터 시작하는 수의 팰린드롬 여부
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i + 1; j++) {
                if (i >= 3) {
                    if (dp[i - 2][j + 1] && arr[j] == arr[j + i - 1]) {
                        dp[i][j] = true;
                    }
                } else if (i == 2) { // 길이가 2인 수에 대한 처리
                    if (arr[j] == arr[j + 1]) {
                        dp[i][j] = true;
                    }
                } else { // i == 1 : 길이가 1이면 무조건 팰린드롬
                    dp[i][j] = true;
                }
            }
        }


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[e - s + 1][s] ? 1 : 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}