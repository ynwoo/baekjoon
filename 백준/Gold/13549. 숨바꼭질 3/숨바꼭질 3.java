import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] distance = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치

		bfs(N);

		System.out.println(distance[K]);
	}

	private static void bfs(int V) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		Arrays.fill(distance, Integer.MAX_VALUE);

		queue.offer(V);
		distance[V] = 0;

		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current == K) {
				return;
			}

			// 갈 수 있는 경로 방법에 대해서
			if (current * 2 <= 100000 && distance[current * 2] == Integer.MAX_VALUE) {
				queue.offer(current * 2);
				distance[current * 2] = distance[current];
			}
			if (0 <= current - 1 && distance[current - 1] == Integer.MAX_VALUE) {
				queue.offer(current - 1);
				distance[current - 1] = distance[current] + 1;
			}
			if (current + 1 <= 100000 && distance[current + 1] == Integer.MAX_VALUE) {
				queue.offer(current + 1);
				distance[current + 1] = distance[current] + 1;
			}
		}
	}

}