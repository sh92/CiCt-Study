package permutation;

public class App {
	public static void main(String[] args) {
		String s1 = "asdfg";
		String s2 = "gadsf";

		boolean b = permutation(s1, s2);
		System.out.println(b);

		boolean b2 = permutation2(s1, s2);
		System.out.println(b2);
	}

	private static boolean permutation2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] letters = new int[256];
		char[] s_array = s1.toCharArray();
		for (char c : s_array)
			letters[c]++;
		for (int i = 0; i < s2.length(); i++) {
			int c = (int) s2.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}

		return true;
	}

	private static boolean permutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return sort(s1).equals(sort(s2));
	}

	private static String sort(String s2) {
		char[] content = s2.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
}
