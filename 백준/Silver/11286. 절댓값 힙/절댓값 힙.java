import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> heap = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x > o2.x)
					return 1;
				else if (o1.x == o2.x) {
					if (o1.y > o2.y) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (heap.size() == 0) {
					System.out.println(0);
				} else {
					System.out.println(heap.poll().y);
				}
			} else {
				if (x < 0) {
					heap.offer(new Point(-x, x));
				} else {
					heap.offer(new Point(x, x));
				}
			}
			//System.out.println(heap);
		}
	}

}