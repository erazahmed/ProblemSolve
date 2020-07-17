import java.util.HashMap;

public class EncodeAndDecodeTinyUrl {

	private String BASE_URL = "http://tinyurl.com/";
	private HashMap<String, String> keyToUrl = new HashMap<String, String>();
	private HashMap<String, String> urlToKey = new HashMap<String, String>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {

		if (longUrl.length() == 0) {
			return null;
		}

		if (urlToKey.containsKey(longUrl)) {
			StringBuilder sb = new StringBuilder();
			sb.append(BASE_URL);
			sb.append(urlToKey.get(longUrl));
			return sb.toString();
		}

		String key = "";
		String availableChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		do {

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int index = (int) (Math.random() * availableChars.length());
				sb.append(availableChars.charAt(index));

			}
			key = sb.toString();

		} while (keyToUrl.containsKey(key));

		urlToKey.put(longUrl, key);
		keyToUrl.put(key, longUrl);

		StringBuilder sb = new StringBuilder();
		sb.append(BASE_URL);
		sb.append(key);
		return sb.toString();

	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return keyToUrl.get(shortUrl.replace(BASE_URL, ""));
	}

}
