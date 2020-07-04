
public class NumberofIslands {

	public int numIslands(char[][] grid) {

		int numIslands = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					numIslands++;
					markNodes(i, j, grid);
				}
			}
		}

		return numIslands;

	}

	private void markNodes(int x, int y, char[][] grid) {

		grid[x][y] = '2';

		if (x - 1 >= 0) {
			if (grid[x - 1][y] == '1') {
				markNodes(x - 1, y, grid);
			}
		}

		if (y - 1 >= 0) {
			if (grid[x][y - 1] == '1') {
				markNodes(x, y - 1, grid);
			}
		}

		if (x + 1 < grid.length) {
			if (grid[x + 1][y] == '1') {
				markNodes(x + 1, y, grid);
			}
		}

		if (y + 1 < grid[x].length) {
			if (grid[x][y + 1] == '1') {
				markNodes(x, y + 1, grid);
			}
		}
	}

}
