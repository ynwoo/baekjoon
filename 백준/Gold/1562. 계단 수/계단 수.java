import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// N : 10
	// dp[10][0][] + dp[10][1][] + ... + dp[10][9][]
	// bit = 1023이어야함

	// bit = bit | (1<<k)
	// dp[i][j][bit] = dp[i-1][j-1][k] + dp[i-1][j+1][k]
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][][] dp = new long[N + 1][10][1024]; // dp[i][j][bit] : i자리 수, 마지막 숫자 = j, 가지고 있는 수(bit)
		final int MOD = 1000000000;

		// n=1일 때
		// 한자리 수, 1,2,...9로 끝나는 수, 그 수를 가지고 있으면 경우의 수 추가
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		// N >= 2일 때
		for (int i = 2; i <= N; i++) {
			// 마지막으로 끝나는 숫자
			for (int j = 0; j <= 9; j++) {
				// 가지고 있는 수
				for (int k = 0; k < 1024; k++) {
					int bit = k | (1 << j);

					if (j == 0) { // 다음 수로 1밖에 못온다
						dp[i][j][bit] = (dp[i][j][bit] % MOD) + (dp[i - 1][j + 1][k] % MOD) % MOD;
					} else if (j == 9) { // 다음 수로 8밖에 못온다.
						dp[i][j][bit] = (dp[i][j][bit] % MOD) + (dp[i - 1][j - 1][k] % MOD) % MOD;
					} else {
						dp[i][j][bit] += ((dp[i - 1][j - 1][k] % MOD) + (dp[i - 1][j + 1][k] % MOD)) % MOD;
					}
				}
			}
		}

		long answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer += dp[N][i][1023] % MOD;
			answer %= MOD;
		}

		System.out.println(answer);
	}
}