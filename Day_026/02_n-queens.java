class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        char[][] chess = new char[n][n];
        for(char[] row : chess){
            Arrays.fill(row, '.');
        }
        
        placeQueens(chess, 0, ans);
        
        return ans;
    }
    
    void placeQueens(char[][] chess, int row, List<List<String>> ans){
        if(row == chess.length){
            ans.add(buildBoard(chess));
        }
        
        for(int col = 0; col < chess.length; col++){
            if(isValid(chess, row, col)){
                chess[row][col] = 'Q';
                placeQueens(chess, row + 1, ans);
                chess[row][col] = '.';
            }
        }
    }
    
    boolean isValid(char[][] chess, int row, int col){
        
//         for each row in that col
        for(int i = 0; i < row; i++){
            if(chess[i][col] == 'Q') return false;
        }
        
//         for right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--,j++){
            if(chess[i][j] == 'Q') return false;
        }
        
//         for left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    List<String> buildBoard(char[][] chess){
        List<String> str = new ArrayList<>();
        for(int row = 0; row < chess.length; row++){
            str.add(new String(chess[row]));
        }
        return str;
    }
}