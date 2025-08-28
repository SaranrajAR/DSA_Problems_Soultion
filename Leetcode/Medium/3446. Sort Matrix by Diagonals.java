import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Group all elements of the matrix by their diagonal
        // Key = (i - j) → identifies a diagonal
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;  // same key means same diagonal
                diagonalMap.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        // Step 2: Sort each diagonal
        //   - If key < 0 → sort in ascending order
        //   - If key >= 0 → sort in descending order
        for (int key : diagonalMap.keySet()) {
            List<Integer> temp = diagonalMap.get(key);
            if (key < 0) {
                Collections.sort(temp); // ascending
            } else {
                temp.sort(Collections.reverseOrder()); // descending
            }
        }

        // Step 3: Place back the sorted values into the grid
        // Maintain an index pointer for each diagonal
        Map<Integer, Integer> diagonalIndex = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;

                // Default index = 0 if not already present
                diagonalIndex.putIfAbsent(key, 0);

                int idx = diagonalIndex.get(key); // current index for this diagonal
                grid[i][j] = diagonalMap.get(key).get(idx); // assign value

                diagonalIndex.put(key, idx + 1); // move to next element
            }
        }

        return grid;
    }
}
