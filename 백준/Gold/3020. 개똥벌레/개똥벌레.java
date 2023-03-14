import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, H;
	static int min = Integer.MAX_VALUE, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[] s = new int[H + 2]; // 석순
		int[] j = new int[H + 2]; // 종유석

		for (int i = 0; i < N / 2; i++) {
			s[Integer.parseInt(br.readLine())]++;
			j[H + 1 - Integer.parseInt(br.readLine())]++;
		}
//		System.out.println(Arrays.toString(s));
//		System.out.println(Arrays.toString(j));
		for (int i = H; i >= 1; i--) {
			s[i] += s[i + 1];
		}
		for (int i = 1; i <= H; i++) {
			j[i] += j[i - 1];
		}
//		System.out.println(Arrays.toString(s));
//		System.out.println(Arrays.toString(j));

		for (int i = 1; i <= H; i++) {
			if (min > s[i] + j[i]) {
				min = s[i] + j[i];
				answer = 1;
			} else if (min == s[i] + j[i]) {
				answer++;
			}
		}
		sb.append(min).append(" ").append(answer);
		System.out.println(sb);
	}
}