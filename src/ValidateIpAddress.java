
public class ValidateIpAddress {

	public String validIPAddress(String IP) {

		String[] digitsV4 = IP.split("\\.");

		if (IP.chars().filter(ch -> ch == '.').count() == 3) {
			return validateIpV4(digitsV4);
		}

		String[] digitsV6 = IP.split(":");

		if (IP.chars().filter(ch -> ch == ':').count() == 7) {
			return validateIpV6(digitsV6);
		}

		return "Neither";

	}

	private String validateIpV6(String[] digits) {

		String allowedChars = "0123456789abcdef";

		if (digits.length != 8) {
			return "Neither";
		}

		for (int i = 0; i < digits.length; i++) {

			if (digits[i].length() == 0 || digits[i].length() > 4) {
				return "Neither";
			}

			String val = digits[i].toLowerCase();
			char[] arr = val.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (!allowedChars.contains(String.valueOf(arr[j]))) {
					return "Neither";
				}
			}

		}
		return "IPv6";
	}

	private String validateIpV4(String[] digits) {

		if (digits.length != 4) {
			return "Neither";
		}

		for (int i = 0; i < digits.length; i++) {

			if (digits[i].length() < 1 || digits[i].length() > 3) {
				return "Neither";
			}

			if (digits[i].length() > 1 && digits[i].startsWith("0")) {
				return "Neither";
			}

			for (int j = 0; j < digits[i].length(); j++) {

				if (!Character.isDigit(digits[i].charAt(j))) {
					return "Neither";
				}

			}

			int val = Integer.parseInt(digits[i]);
			if (val < 0 || val > 255) {
				return "Neither";
			}

		}
		return "IPv4";
	}

}
