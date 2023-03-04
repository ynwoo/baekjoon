import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, maxRoom = Integer.MIN_VALUE;
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int roomCnt = 0;

		board = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 이 성에 있는 방의 개수
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}
				bfs(i, j);
				//System.out.println(i + " " + j);
				roomCnt++;
			}
		}
		
		System.out.println(roomCnt);
		System.out.println(maxRoom);
		
		// 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 벽을 제거하고 bfs돌리기
				for (int d = 0; d < 4; d++) {
					if((board[i][j] & wall[d]) != 0) { // 벽이 있으면
						board[i][j] -= wall[d]; //벽 없애기
						visited = new boolean[M][N];
						bfs(i, j);
						board[i][j] += wall[d];
					}
				}
			}
		}
		System.out.println(maxRoom);
	}

	// 서, 북, 동, 남
	static int[] wall = { 1, 2, 4, 8 };
	static int[] di = { 0, -1, 0, 1 };
	static int[] dj = { -1, 0, 1, 0 };

	private static void bfs(int i, int j) {
		int cnt = 0;
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.offer(new Point(i,j));
		visited[i][j] = true;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			cnt++;
			// 4방향에 벽이 있는지 체크 후, 벽이 없으면 큐에 추가,
			for (int d = 0; d < 4; d++) {
				int ni = cur.x +di[d];
				int nj = cur.y +dj[d];
				if(ni<0 || M <=ni ||nj<0 || N<=nj) { // 범위 벗어남
					continue;
				}
				if(visited[ni][nj]) { // 이미 방문함
					continue;
				}
				if ((board[cur.x][cur.y] & wall[d]) != 0) { // 벽이 있다.
					continue;
				}
				
				queue.offer(new Point(ni, nj));
				visited[ni][nj] = true;
				
			}
		}
		maxRoom = Math.max(maxRoom, cnt);
	}
}