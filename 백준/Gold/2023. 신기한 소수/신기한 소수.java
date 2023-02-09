import java.util.Scanner;

public class Main {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] startNum = { 2, 3, 5, 7 };
		for (int num : startNum) {
			findInterestingPrime(1, num);
		}

	}

	private static void findInterestingPrime(int cnt, int num) {
		if (cnt == n) {
			if (isPrimeNum(num)) {
				System.out.println(num);
			}
		}
		for (int i = 1; i < 10; i++) {
			if (isPrimeNum(num * 10 + i)) {
				findInterestingPrime(cnt + 1, num * 10 + i);
			}
		}

	}

	private static boolean isPrimeNum(int num) {
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
