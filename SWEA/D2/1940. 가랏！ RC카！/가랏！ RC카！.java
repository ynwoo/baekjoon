import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int currentSpeed = 0, answer = 0;
		for (int testCase = 1; testCase <= T; testCase++) {
			currentSpeed = 0;
			answer = 0;
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command == 1) {
					int a = Integer.parseInt(st.nextToken());
					currentSpeed += a;
				} else if (command == 2) {
					int a = Integer.parseInt(st.nextToken());
					currentSpeed = (currentSpeed - a >= 0) ? currentSpeed - a : 0;
				}
				answer += currentSpeed;
			}

			System.out.printf("#%d %d\n", testCase, answer);
		}

	}
}
