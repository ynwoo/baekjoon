import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				int horizontalCnt = 0, verticalCnt = 0;
				for (int j = 0; j < n; j++) {
					// 가로 체크
					if (arr[i][j] == 1) {
						horizontalCnt++;
					} else {
						if (horizontalCnt == k)
							answer++;
						horizontalCnt = 0;
					}
					// 세로 체크
					if (arr[j][i] == 1) {
						verticalCnt++;

					} else {
						if (verticalCnt == k)
							answer++;
						verticalCnt = 0;
					}
				}
				if (horizontalCnt == k) {
					answer++;
				}
				if (verticalCnt == k) {
					answer++;
				}
			}

			System.out.printf("#%d %d\n", testCase, answer);
		}

	}
}