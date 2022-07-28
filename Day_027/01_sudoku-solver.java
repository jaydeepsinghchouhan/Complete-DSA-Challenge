class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, board.length, 0, 0); // board, board.length, starting row, starting col
    }

    boolean solve(char[][] board, int n, int row, int col) {
        if (col == n) {
            row++;
            col = 0;
        }
        
        if (row >= n) return true;

        if (board[row][col] != '.')
            return solve(board, n, row, col + 1); //if not "." we go to next element in same row

        for (char i = '1'; i <= '9'; i++) {
            if (isValid(board, n, row, col, i)) {
                board[row][col] = i;
                if (solve(board, n, row, col+1)) return true;   
                else board[row][col] = '.'; //incase of failure...backtrack
            }
        }

        return false;
    }

    boolean isValid(char[][] board, int n, int row, int col, char value) {
        for (int x = 0; x < n; x++) {
            if ((board[row][x] == value) || (board[x][col] == value) || board[3*(row/3)+(x / 3)][3 * (col / 3) + (x % 3)] == value) return false;
        }
        return true;
    }
}