class Solution {
public int minPathSum(int[][] grid) {
    int row = grid.length-1;
    int col = grid[0].length-1;
    int[][] dp = new int[row+1][col+1];
    return minPathSum(grid,row,col,dp);
}

int minPathSum(int[][] grid, int row, int col, int[][] dp){
    if(row == 0 && col == 0) return grid[row][col];
    
    if(dp[row][col] != 0) return dp[row][col];
    
    if(row != 0 && col == 0) return dp[row][col] = 
        grid[row][col]+minPathSum(grid,row-1,col,dp);
    
    if(row == 0 && col != 0) return dp[row][col] = 
        grid[row][col]+minPathSum(grid,row,col-1,dp);
    
    return dp[row][col] = grid[row][col] + 
Math.min(minPathSum(grid,row-1,col,dp),minPathSum(grid,row,col-1,dp));
}
}

class Solution {
    public int minPathSum(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dp=new int[rows][cols];
        dp[0][0]=grid[0][0];
        for(int i=1;i<rows;i++)
        {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int j=1;j<cols;j++)
        {
         dp[0][j]=grid[0][j]+dp[0][j-1];       
        }
        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<cols;j++)
            {
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
    //    System.out.println(dp[0]);
        return dp[rows-1][cols-1];
    }
}
