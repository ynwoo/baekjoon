import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] d = new int[6];
		int[] arr = new int[6];
		int m = 0;
		int k = sc.nextInt();
		int evenMax = Integer.MIN_VALUE;
		int oddMax = Integer.MIN_VALUE;

		for (int i = 0; i < 6; i++) {
			d[i] = sc.nextInt();
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (arr[i] > evenMax)
					evenMax = arr[i];
			} else {
				if (arr[i] > oddMax)
					oddMax = arr[i];
			}
			if (i > 0) {
				if (d[i - 1] == 1 && d[i] == 4) {
					continue;
				}
				if (d[i - 1] == 4 && d[i] == 2) {
					continue;
				}
				if (d[i - 1] == 2 && d[i] == 3) {
					continue;
				}
				if (d[i - 1] == 3 && d[i] == 1) {
					continue;
				}
				m = arr[i-1] * arr[i];
			}
		}
		if(m == 0) {
			m = arr[0] * arr[5];
		}
		System.out.println((evenMax * oddMax - m) * k);
	}

}
