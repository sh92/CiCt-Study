package bruteForece;

import java.util.ArrayList;

public class App {

	// BruteForce
	static int longestSequence(int n) {
		if (n == -1)
			return Integer.BYTES * 8;
		ArrayList<Integer> sequences = getAlternatingSquences(n);
		return findLongestSequence(sequences);
	}

	private static ArrayList<Integer> getAlternatingSquences(int n) {
		ArrayList<Integer> sequneces = new ArrayList<Integer>();
		int searchingFor = 0;
		int counter = 0;

		for (int i = 0; i < Integer.BYTES; i++) {
			if ((n & 1) != searchingFor) {
				sequneces.add(counter);
				searchingFor = n & 1;
				counter = 0;
			}
			counter++;
			n >>>= 1;
		}
		sequneces.add(counter);
		return sequneces;
	}

	private static int findLongestSequence(ArrayList<Integer> seq) {
		int maxSeq = 1;
		for (int i = 0; i < seq.size(); i += 2) {
			int zerosSeq = seq.get(i);
			int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
			int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;

			int thisSeq = 0;
			if (zerosSeq == 1) {
				thisSeq = onesSeqLeft + 1 + onesSeqRight;
			} else if (zerosSeq > 1) {
				thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft);
			} else if (zerosSeq == 0) {
				thisSeq = Math.max(onesSeqLeft, onesSeqRight);
			}
			maxSeq = Math.max(thisSeq, maxSeq);

		}
		return maxSeq;
	}

	// optimal Algorithms
	public static int flipBit(int a) {
		if (~a == 0) {
			return Integer.BYTES * 8;
		}
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1;
		while (a != 0) {
			if ((a & 1) == 0) {
				currentLength++;
			} else if ((a & 1) == 0) {
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			a >>>= 1;
			System.out.println(a);

		}
		return maxLength;
	}

	public static void main(String[] args) {
		int input = 1775;
		System.out.println(longestSequence(input));
		System.out.println(flipBit(input));

	}
}
