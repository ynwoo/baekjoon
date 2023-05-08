import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			stack.push(Integer.parseInt(st.nextToken()));
		}

		int[] answer = new int[n];
		int k = 0;
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			while (!stack2.isEmpty()) {
				int m = stack2.pop();
				if (cur < m) {
					answer[k++] = m;
					stack2.push(m);
					break;
				}
			}
			if (stack2.isEmpty()) {
				answer[k++] = -1;
			}
			stack2.push(cur);
		}

		for (int i = n - 1; i >= 0; i--) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
	}

}