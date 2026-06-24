class Solution {
    public static int knapsack(int W, int val[], int wt[]) {
        
        int n = val.length;

        
        int[][] memo = new int[n + 1][W + 1];

        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++)
                memo[i][j] = -1;
        }

        return knapsackRec(W, val, wt, n, memo);
    }
    
     static int knapsackRec(int W, int[] val, int[] wt, int n, int[][] memo) {

        
        if (n == 0 || W == 0)
            return 0;

        
        if (memo[n][W] != -1)
            return memo[n][W];

        int pick = 0;

        
        if (wt[n - 1] <= W)
            pick = val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1, memo);

        
        int notPick = knapsackRec(W, val, wt, n - 1, memo);

        
        return memo[n][W] = Math.max(pick, notPick);
    }

}
