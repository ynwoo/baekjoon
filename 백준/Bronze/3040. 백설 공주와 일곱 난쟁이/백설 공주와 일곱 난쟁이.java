import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr = new int[9];
	static int[] seven = new int[7];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += seven[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(seven[i]);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			seven[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}

}