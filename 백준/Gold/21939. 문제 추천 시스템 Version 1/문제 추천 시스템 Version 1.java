import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Problem implements Comparable<Problem> {
	Integer difficulty;
	Integer pNum;

	public Problem(int difficulty, int pNum) {
		this.difficulty = difficulty;
		this.pNum = pNum;
	}

	@Override
	public int compareTo(Problem o) {
		if (this.difficulty > o.difficulty) {
			return 1;
		} else if (this.difficulty == o.difficulty) {
			if (this.pNum > o.pNum) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] isRecommend = new int[100001];
		PriorityQueue<Problem> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Problem> minHeap = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			Problem problem = new Problem(l, p);
			isRecommend[p] = l;

			maxHeap.offer(problem);
			minHeap.offer(problem);
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				Problem problem = new Problem(l, p);
				isRecommend[p] = l;

				maxHeap.offer(problem);
				minHeap.offer(problem);
			} else if (command.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					while (isRecommend[maxHeap.peek().pNum] != maxHeap.peek().difficulty) {
						maxHeap.poll();
					}
					bw.write(maxHeap.peek().pNum.toString());
					bw.newLine();
					bw.flush();
				} else {
					while (isRecommend[minHeap.peek().pNum] != minHeap.peek().difficulty) {
						minHeap.poll();
					}
					bw.write(minHeap.peek().pNum.toString());
					bw.newLine();
					bw.flush();
				}
			} else { // command.equals("solved")
				int p = Integer.parseInt(st.nextToken());
				isRecommend[p] = 0;
			}
		}
		br.close();
		bw.close();
	}

}