package replaceSpace;

public class App {
	public static void main(String[] args) {
		char[] array = new char[2048];
		String s1 = "This is Sparta";
		char[] s1_char = s1.toCharArray();
		int array_length = s1_char.length;
		System.arraycopy(s1_char, 0, array, 0, array_length);
		System.out.println(array);
		replaceSpaces(array, array_length);
		System.out.println(array);

	}

	private static void replaceSpaces(char[] array, int array_length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < array_length; i++) {
			if (array[i] == ' ')
				spaceCount++;
		}
		newLength = array_length + spaceCount + 2;
		array[newLength] = '\0';

		for (i = array_length - 1; i >= 0; i--) {
			if (array[i] == ' ') {
				array[newLength - 1] = '0';
				array[newLength - 2] = '2';
				array[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				array[newLength - 1] = array[i];
				newLength = newLength - 1;
			}
		}
	}
}
