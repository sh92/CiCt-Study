package isRotation;

public class App {
	public static void main(String[] args) {

		String x = "wat";
		String y = "erbottle";
		String s1 = x + y;
		String s2 = y + x;
		boolean b = isRotate(s1, s2);
		System.out.println(b);

	}

	private static boolean isRotate(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String newString = s1 + s1;
			return isSubstring(newString, s2);
		}
		return false;
	}

	private static boolean isSubstring(String newString, String s2) {
		return newString.contains(s2);
	}
}
