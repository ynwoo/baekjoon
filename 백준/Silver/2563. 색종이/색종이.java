import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] arr = new int[100][100];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {
					arr[a][b] = 1;
				}
			}

		}
		int answer = 0;
		for (int a = 0; a < 100; a++) {
			for (int b = 0; b < 100; b++) {
				if(arr[a][b] == 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}