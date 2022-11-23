class Solution {
    Map<Integer, Set<Character>> colMap = new HashMap<>();
    Map<Integer, Set<Character>> rowMap = new HashMap<>();
    Map<Integer, Set<Character>> cellMap = new HashMap<>();
    
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++) rowMap.put(row, new HashSet<Character>());
        for(int col = 0; col < 9; col++) colMap.put(col, new HashSet<Character>());
        for(int cell = 0; cell < 9; cell++) cellMap.put(cell, new HashSet<Character>());
      
        for(int i=0; i< 9; i++){
            for(int j=0; j< 9; j++){
                char currChar = board[i][j];
                if(currChar == '.') continue;
                if( !rowMap.get(i).add(currChar)) return false; //is already present
                if( !colMap.get(j).add(currChar)) return false; //is already present
                if( !cellMap.get(i/3*3 + j/3).add(currChar)) return false; //is already present
            }
        }
        return true;
    }
}