package setZero;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 4;
		while (n <= 3) {
			System.out.println("Enter n:");
			n = scanner.nextInt();
			System.out.println("n should be bigger than 3");

		}
		int cnt = 0;
		int[][] matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = cnt++;
			}
		}
		matrix[2][1] = 0;
		printArray(matrix);
		setZero(matrix);
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

	private static void setZero(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (column[j] || row[i]) {
					matrix[i][j] = 0;
				}
			}
		}

	}
}
