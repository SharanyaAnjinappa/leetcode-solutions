import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // Store litter number for each cell
        int[][] litterIndex = new int[m][n];

        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;

        // Find starting position and number each litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                }

                else if (cell == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        /*
         * visited[row][col][energyLeft][mask]
         */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

        // Initially all litter is remaining
        int initialMask = (1 << litterCount) - 1;

        queue.offer(new int[]{
                startRow,
                startCol,
                energy,
                initialMask
        });

        visited[startRow][startCol][energy][initialMask] = true;

        int[] directions = {-1, 0, 1, 0, -1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all positions at current move level
            for (int q = 0; q < size; q++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int currentEnergy = current[2];
                int mask = current[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // Cannot move without energy
                if (currentEnergy == 0) {
                    continue;
                }

                // Try 4 directions
                for (int d = 0; d < 4; d++) {

                    int newRow = row + directions[d];
                    int newCol = col + directions[d + 1];

                    // Check boundaries and obstacles
                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n ||
                        classroom[newRow].charAt(newCol) == 'X') {
                        continue;
                    }

                    int newEnergy;

                    // Reset area restores full energy
                    if (classroom[newRow].charAt(newCol) == 'R') {
                        newEnergy = energy;
                    } else {
                        newEnergy = currentEnergy - 1;
                    }

                    int newMask = mask;

                    // Collect litter
                    if (classroom[newRow].charAt(newCol) == 'L') {

                        int index = litterIndex[newRow][newCol];

                        // Remove this litter from mask
                        newMask &= ~(1 << index);
                    }

                    // Add new state if not visited
                    if (!visited[newRow][newCol][newEnergy][newMask]) {

                        visited[newRow][newCol][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                                newRow,
                                newCol,
                                newEnergy,
                                newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}