class NumMatrix {

    int[][] prefixSum;
    int[][] matrix;
   
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m][n];
        
        //calculate prefixSum
        for(int i = 0; i< m ; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(i==0 && j ==0){
                    prefixSum[i][j] = matrix[i][j];
                }
                else if(i == 0)
                {
                    prefixSum[i][j] = matrix[i][j] + prefixSum[i][j-1];
                }
                else if(j == 0){
                    prefixSum[i][j] = matrix[i][j] + prefixSum[i-1][j];
                }
                else{
                prefixSum[i][j] = matrix[i][j] + prefixSum[i][j-1] 
                + prefixSum[i-1][j] - prefixSum[i-1][j-1];
                }

            }
        }

        System.out.println(Arrays.deepToString(prefixSum));
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (matrix.length == 1 && matrix[0].length == 1) 
        {
            return matrix[0][0];
        }
       int sum = prefixSum[row2][col2];
        
        // Subtract the rows above the region (if row1 > 0)
        if (row1 > 0) {
            sum -= prefixSum[row1 - 1][col2];
        }

        // Subtract the columns left of the region (if col1 > 0)
        if (col1 > 0) {
            sum -= prefixSum[row2][col1 - 1];
        }

        // Add the top-left overlap (if row1 > 0 and col1 > 0)
        if (row1 > 0 && col1 > 0) {
            sum += prefixSum[row1 - 1][col1 - 1];
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */