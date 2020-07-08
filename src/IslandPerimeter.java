
public class IslandPerimeter {

	int perimeter = 0;

	public int islandPerimeter(int[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					markNodes(i, j, grid);
					break;
				}
			}
		}

		return perimeter;

	}

	private void markNodes(int x, int y, int[][] grid) {

		int initialPerimeter = 4;
		grid[x][y] = 2;

		if (x - 1 >= 0) {
			if (grid[x - 1][y] == 2) {
				initialPerimeter--;
			} else if (grid[x - 1][y] == 1) {
				markNodes(x - 1, y, grid);
				initialPerimeter--;
			}
		}

		if (y - 1 >= 0) {
			if (grid[x][y - 1] == 2) {
				initialPerimeter--;
			} else if (grid[x][y - 1] == 1) {
				markNodes(x, y - 1, grid);
				initialPerimeter--;
			}
		}

		if (x + 1 < grid.length) {
			if (grid[x + 1][y] == 2) {
				initialPerimeter--;
			} else if (grid[x + 1][y] == 1) {
				markNodes(x + 1, y, grid);
				initialPerimeter--;

			}
		}

		if (y + 1 < grid[x].length) {
			if (grid[x][y + 1] == 2) {
				initialPerimeter--;
			} else if (grid[x][y + 1] == 1) {
				markNodes(x, y + 1, grid);
				initialPerimeter--;
			}
		}
		perimeter += initialPerimeter;
	}

}
