import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] input, numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[9];
		numbers = new int[7];

		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}

		combination(0, 0);

	}

	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			// 합이 100이면 출력하고 프로그램 종료
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			if (sum == 100) {
				Arrays.sort(numbers);
				for (int i = 0; i < 7; i++) {
					System.out.println(numbers[i]);
				}
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, start + 1);
		}

	}

}
