import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class MyPoint2 {
	int x, y, currentK;

	public MyPoint2(int x, int y, int currentK) {
		this.x = x;
		this.y = y;
		this.currentK = currentK;
	}

}

public class Main {
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int answer = bfs(0, 0, 1);
		System.out.println(answer);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	static int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static int bfs(int i, int j, int k) {
		Queue<MyPoint2> queue = new ArrayDeque<MyPoint2>();
		boolean[][][] visited = new boolean[2][N][M];
		int level = 1, size = 0;

		visited[k][i][j] = true;
		queue.offer(new MyPoint2(i, j, k));
		while (!queue.isEmpty()) {
			size = queue.size();
			while (--size >= 0) {
				MyPoint2 current = queue.poll();
				if (current.x == N - 1 && current.y == M - 1) {
					// 도착
					return level;
				}
				// 이동할 수 있는 곳이라면 큐에 추가, 방문처리

				// 평범한 이동
				for (int d = 0; d < 4; d++) {
					int ni = current.x + move[d][0];
					int nj = current.y + move[d][1];
					if (ni < 0 || N <= ni || nj < 0 || M <= nj || visited[current.currentK][ni][nj]
							|| map[ni][nj] == '1') {
						continue;
					}
					visited[current.currentK][ni][nj] = true;
					queue.offer(new MyPoint2(ni, nj, current.currentK));
				}

				// 벽 부수고 이동
				if (current.currentK > 0) {
					for (int d = 0; d < 4; d++) {
						int ni = current.x + move[d][0];
						int nj = current.y + move[d][1];
						if (ni < 0 || N <= ni || nj < 0 || M <= nj || visited[current.currentK][ni][nj] || map[ni][nj] == '0') {
							continue;
						}
						visited[current.currentK - 1][ni][nj] = true;
						queue.offer(new MyPoint2(ni, nj, current.currentK - 1));
					}
				}

			}

			level++;
		}
		return -1;
	}
}