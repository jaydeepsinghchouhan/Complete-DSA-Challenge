class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)){
                    return true;
                }
            }
    }
         return false;
    }
        public boolean dfs(char[][] board, int i, int j, int count, String word){
            // base case
            if(count == word.length()) return true;
            
            // Range is still in the given
            if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)){
                return false;
            }
            // we change the values of the board temporarily so we don't accidentaly include it again
            char temp = board[i][j];
            board[i][j] = ' ';
            // Boolean function that returns if we found the complete string or not
            boolean found = dfs(board,  i + 1, j , count + 1, word) 
                || dfs(board,  i - 1, j, count + 1, word) 
                || dfs(board,  i, j + 1, count + 1, word)
                || dfs(board,  i , j - 1, count + 1, word);
            
            board[i][j] = temp;
            return found;
        }
}