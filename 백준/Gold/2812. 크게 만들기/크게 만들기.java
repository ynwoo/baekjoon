import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] numbers = new int[N];
		String input = br.readLine();
		for (int i = 0; i < N; i++) {
			numbers[i] = input.charAt(i) - '0';
		}

		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		deque.addLast(numbers[0]);
		for (int i = 1; i < N; i++) {
			int top = deque.peekLast();
			while (!deque.isEmpty() && top < numbers[i] && K > 0) {
				deque.pollLast();
				if (!deque.isEmpty()) {
					top = deque.peekLast();
				}
				K--;
			}
			deque.addLast(numbers[i]);
		}
		while (K > 0) {
			deque.pollLast();
			K--;
		}
		if (deque.isEmpty()) {
			System.out.println(0);
		}
		while (!deque.isEmpty()) {
			System.out.print(deque.pollFirst());
		}
	}
}