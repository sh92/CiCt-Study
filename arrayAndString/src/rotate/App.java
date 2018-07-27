package rotate;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int cnt = 0;
		int[][] matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = cnt++;
			}
		}
		printArray(matrix);
		rotate(matrix, n);
		printArray(matrix);
	}

	private static void printArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%2d ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i];

				matrix[first][offset] = matrix[last - offset][first];

				matrix[last - offset][first] = matrix[last][last - offset];

				matrix[last][last - offset] = matrix[i][last];

				matrix[i][last] = top;

			}
		}

	}

}
