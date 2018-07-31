package bitSwapRequired;

public class App {

	// XOR
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >>> 1) {
			count += c & 1;
		}
		return count;
	}

	// Pairwise Swap
	public static int bitSwapRequired2(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(bitSwapRequired(29, 15));
		System.out.println(bitSwapRequired2(29, 15));
	}
}
