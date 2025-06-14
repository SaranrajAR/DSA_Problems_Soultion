class Solution {

    // Finds the row index of the maximum element in a given column
    public int getMaxRowIndexInColumn(int[][] mat, int col) {
        int maxRow = 0;
        for (int row = 1; row < mat.length; row++) {
            if (mat[row][col] > mat[maxRow][col]) {
                maxRow = row;
            }
        }
        return maxRow;
    }

    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0;
        int high = cols - 1;

        while (low <= high) {
            int midCol = (low + high) / 2;
            int maxRow = getMaxRowIndexInColumn(mat, midCol);

            int current = mat[maxRow][midCol];
            int left = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int right = (midCol + 1 < cols) ? mat[maxRow][midCol + 1] : -1;

            if (current > left && current > right) {
                return new int[] { maxRow, midCol };  // Peak found
            } else if (current < left) {
                high = midCol - 1;  // Move left
            } else {
                low = midCol + 1;   // Move right
            }
        }

        return new int[] { -1, -1 }; // Should never reach here
    }
}
