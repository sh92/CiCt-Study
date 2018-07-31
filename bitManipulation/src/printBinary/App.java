package printBinary;

public class App {

	static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "Error";
		}
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			if (binary.length() > 32) {
				return "Error";
			}
			double r = num * 2;
			if (r >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();

	}

	static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "Error";
		}
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			if (binary.length() >= 32) {
				return "Error";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();

	}

	public static void main(String[] args) {
		double base10 = 0.25;
		System.out.println(printBinary(base10));
	}
}
