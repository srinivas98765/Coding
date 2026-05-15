class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int n=matrix.length;
       int a[][] =new int[n][n];
       a[0]=matrix[0].clone();
       for(int i=1;i<matrix.length;i++)
       {
        for(int j=0;j<matrix[0].length;j++)
        {
            if(j==0)
            {
             a[i][j]=Math.min(a[i-1][j],a[i-1][j+1])+matrix[i][j];
            }else if(j==n-1)
            {
               a[i][j]=Math.min(a[i-1][j],a[i-1][j-1])+matrix[i][j];
            }
            else
            {
                a[i][j]=Math.min(a[i-1][j],Math.min(a[i-1][j-1],a[i-1][j+1]))+matrix[i][j];
            }
        }
       }
       int min=Integer.MAX_VALUE;
       for(int i=0;i<matrix.length;i++)
       {
        min=Math.min(min,a[n-1][i]);
       }
       return min;
    }
}
