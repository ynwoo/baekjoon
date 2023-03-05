import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long B;
	static int[][] matrix;
	static int[][] answer;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		matrix = new int[N][N];
		answer = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (i == j) {
					answer[i][j] = 1;
				}
			}
		}
		if (B == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print((matrix[i][j] % 1000) + " ");
				}
				System.out.println();
			}
		} else {
			answer = getBSquare(B);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(answer[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static int[][] getBSquare(long B) {
		if (B == 1) {
			return matrix;
		}
		int[][] temp = getBSquare(B / 2);
		if (B % 2 == 0) {
			return multiply(temp, temp);
		} else {
			return multiply(multiply(temp, temp), matrix);
		}

	}

	private static int[][] multiply(int[][] m1, int[][] m2) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int[] aArray = getRowArray(i, m1);
				int[] bArray = getColArray(j, m2);
				result[i][j] = getSpace(aArray, bArray);
			}
		}
		return result;
	}

	private static int[] getRowArray(int i, int[][] m1) {
		int[] result = new int[N];
		for (int j = 0; j < N; j++) {
			result[j] = m1[i][j];
		}
		return result;
	}

	private static int[] getColArray(int j, int[][] m2) {
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = m2[i][j];
		}
		return result;
	}

	// 나머지(Modulo) 연산 분배법칙
	// (A + B) % p = ((A % p) + (B % p)) % p
	// (A * B) % p = ((A % p) * (B % p)) % p
	// (A - B) % p = ((A % p) - (B % p) + p) % p
	private static int getSpace(int[] a, int[] b) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += (((a[i] % 1000) * (b[i] % 1000)) % 1000);
		}
		return sum % 1000;
	}
}