import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static Queue<Integer[]> snake = new LinkedList<Integer[]>();
	static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 동 남 서 북
	static int time;
	static int currentDi = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		int headI = 0, headJ = 0; // 초기 위치
		currentDi = 0; // 초기 방향

		board[0][0] = 2; // 보드에 뱀 표시
		Integer[] temp = { headI, headJ };
		snake.add(temp); // 몸통 추가

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row - 1][col - 1] = 1; // 사과 위치 표시
		}

		int l = Integer.parseInt(br.readLine());
		label: for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			// System.out.println(x + " " + c);

			// 여기서 구현! 근데 이미 뱀이 차지하고 있는 공간인 거를 어떻게 파악할 것인가? board 2차원 배열에서 사과는 1로 뱀은 2로
			// 표시...
			// 만약 뱀의 길이가 10이고 한칸 움직였을 때 꼬리칸에 있는 2를 0으로 바꿔줘야 하는데 어떻게 바꿔줄꺼임???
			// 1. 뱀이 차지하고 있는 공간의 인덱스를 전부 저장한다. -> 어떻게 저장?? -> 큐를 이용하자

			// 큐 그림 <-----------
			// 뱀 꼬리 ----------- 뱀 머리
			//
			// 뱀 꼬리 ----------- 뱀 머리
			while (time != x) {
				int ni = headI + direction[currentDi][0];
				int nj = headJ + direction[currentDi][1];
				if (0 <= ni && ni < n && 0 <= nj && nj < n && board[ni][nj] != 2) { // 새롭게 이동한 곳이 범위 안이면서 2가 아니어야함
					time++;
					headI = ni;
					headJ = nj;

					if (board[ni][nj] == 0) { // 사과를 못먹음
						Integer[] tmp = snake.poll(); // 꼬리칸 없애줌
						board[tmp[0]][tmp[1]] = 0;
					} else {
						board[ni][nj] = 0; // 사과를 먹으면 없애줌
					}

					Integer[] tmp = { headI, headJ };
					snake.add(tmp); // 새로운 머리 추가
					board[tmp[0]][tmp[1]] = 2;
				} else {
					break label;
				}
			}
			if (c == 'L') {// 왼쪽 90도 회전
				currentDi = (currentDi - 1 >= 0) ? currentDi - 1 : 3;
			} else { // 오른쪽 90도 회전
				currentDi = (currentDi + 1 < 4) ? currentDi + 1 : 0;
			}
//			System.out.println(headI + " " + headJ + " " + currentDi);
		}
		// 명령이 다 끝났는데도 뱀이 살아있으면 죽을 때 까지 시간 카운트 추가!!!
		while (true) {
			int ni = headI + direction[currentDi][0];
			int nj = headJ + direction[currentDi][1];
			if (0 <= ni && ni < n && 0 <= nj && nj < n && board[ni][nj] != 2) { // 새롭게 이동한 곳이 범위 안이면서 2가 아니어야함
				time++;
				headI = ni;
				headJ = nj;

				if (board[ni][nj] == 0) { // 사과를 못먹음
					Integer[] tmp = snake.poll(); // 꼬리칸 없애줌
					board[tmp[0]][tmp[1]] = 0;
				}

				Integer[] tmp = { headI, headJ };
				snake.add(tmp); // 새로운 머리 추가
				board[tmp[0]][tmp[1]] = 2;
			} else {
				break;
			}
		}

		System.out.println(time + 1);
	}

}
