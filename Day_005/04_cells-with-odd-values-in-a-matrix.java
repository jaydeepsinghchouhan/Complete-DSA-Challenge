class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int oddCount = 0;
        int updateArray[][] = new int[m][n];
        
        for(int[] i : indices){
           int  row = i[0];
           int col = i[1];
            
            for(int j = 0; j < n; j++){
                updateArray[row][j] += 1;
            }
            for(int k = 0; k < m; k++){
                updateArray[k][col] += 1;
            }
        }
        
        for(int[] i: updateArray){
            for(int j : i){
                if(j % 2 != 0) oddCount++;
            }
        }
        return oddCount;
    }
}