package isUniqueChar;

public class App {
	public static void main(String[] args) {
		String str1 = "ABsdadaa";
		String str2 = "Abcdefg";
		System.out.println(isUniqueueChar1(str1));
		System.out.println(isUniqueueChar1(str2));
	}

	private static boolean isUniqueueChar2(String str) {
		if (str.length() > 256)
			return false;
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	private static boolean isUniqueueChar1(String str) {
		if (str.length() > 256)
			return false;
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}
