package updateBits;

public class App {
	static int udpateBits(int n, int m, int i, int j) {
		int allOnes = ~0;
		int left = allOnes << (j + 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		int n_cleared = n & mask;
		System.out.println(n_cleared);
		int m_shifted = m << i;
		System.out.println(m_shifted);
		return n_cleared | m_shifted;
	}

	public static void main(String[] args) {
		int N = 1 << 10;
		int M = 19;
		int i = 2;
		int j = 6;
		System.out.println(N);
		System.out.println(M);
		int ret = udpateBits(N, M, i, j);
		System.out.println(ret);

	}
}
