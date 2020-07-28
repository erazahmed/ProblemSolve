
public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int currentColor = image[sr][sc];

		if (currentColor != newColor) {
			fillColor(image, sr, sc, newColor, currentColor);
		}

		return image;

	}

	private void fillColor(int[][] image, int sr, int sc, int newColor, int currentColor) {

		image[sr][sc] = newColor;

		if (sr - 1 >= 0) {
			if (image[sr - 1][sc] == currentColor) {
				fillColor(image, sr - 1, sc, newColor, currentColor);
			}
		}

		if (sc - 1 >= 0) {
			if (image[sr][sc - 1] == currentColor) {
				fillColor(image, sr, sc - 1, newColor, currentColor);
			}
		}

		if (sr + 1 < image.length) {
			if (image[sr + 1][sc] == currentColor) {
				fillColor(image, sr + 1, sc, newColor, currentColor);
			}
		}

		if (sc + 1 < image[sr].length) {
			if (image[sr][sc + 1] == currentColor) {
				fillColor(image, sr, sc + 1, newColor, currentColor);
			}
		}

	}

}
