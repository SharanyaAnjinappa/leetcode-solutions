class Solution {

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        int[][] dp = new int[n + 1][n + 1];

        int[] suffix = new int[n + 1];

        // Total stones from i to the end
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // Fill DP
        for (int i = n - 1; i >= 0; i--) {

            for (int M = n; M >= 1; M--) {

                // Can take all remaining piles
                if (i + 2 * M >= n) {
                    dp[i][M] = suffix[i];
                    continue;
                }

                // Try taking 1 to 2*M piles
                for (int x = 1; x <= 2 * M; x++) {

                    dp[i][M] = Math.max(
                        dp[i][M],
                        suffix[i] -
                        dp[i + x][Math.max(M, x)]
                    );
                }
            }
        }

        return dp[0][1];
    }
}