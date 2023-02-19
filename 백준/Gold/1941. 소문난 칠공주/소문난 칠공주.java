import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[][] arr = new char[5][5];
	static Point[] cases = new Point[7];
	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };
	static boolean[][] isVisited = new boolean[5][5];
	static int[][] temp = new int[5][5];
	static int answer, studentCnt;

	public static void main(String[] args) throws Exception {
		// 입력
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// 구현
		combination(0, 0);

		// 출력
		System.out.println(answer);
	}

	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sCnt = 0;
			temp = new int[5][5];
			studentCnt = 0;

			for (int i = 0; i < 7; i++) {
				if (arr[cases[i].x][cases[i].y] == 'S') {
					sCnt++;
				}
				temp[cases[i].x][cases[i].y] = 1;
			}

			if (sCnt >= 4) { // 이다솜파 4명 이상
				// dfs로 돌렸을 때 학생 수가 7이 나오면 answer++
				isVisited = new boolean[5][5];
				int startI = cases[0].x;
				int startJ = cases[0].y;
				dfs(startI, startJ); // 다 인접해있는지 확인
				if (studentCnt == 7) {
					answer++;
				}
			}

			return;
		}

		for (int i = start; i < 25; i++) {
			cases[cnt] = new Point(i / 5, i % 5);
			combination(cnt + 1, i + 1);
		}
	}

	private static void dfs(int i, int j) {
		isVisited[i][j] = true;
		studentCnt++;
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (0 <= ni && ni < 5 && 0 <= nj && nj < 5 && !isVisited[ni][nj] && temp[ni][nj] == 1) {
				dfs(ni, nj);
			}
		}
	}

}