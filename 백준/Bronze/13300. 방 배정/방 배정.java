import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] students = new int[2][7];
		int n, k, answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			students[s][y]++;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if (students[i][j] > 0) {
					if (students[i][j] <= k) {
						answer++;
					} else {
						if (students[i][j] % k == 0) {
							answer += students[i][j] / k;
						} else {
							answer += students[i][j] / k + 1;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}