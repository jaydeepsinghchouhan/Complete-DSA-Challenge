class Solution {

    private static boolean isFound;
    private static int [][] points = { {1,0},{-1,0},{0,1},{0,-1}};
    
    private static void existDFS(char [][] board, String s, int x, int y, boolean[][] visited, StringBuilder path) {
        if(path.toString().equals(s)) {
            isFound = true;
            return;
        }
        if(!(x>=0 && x<board.length && y>=0 && y<board[0].length && !visited[x][y])) return;
        if(path.length() > s.length()) return;
        if((path.length() != 0 && s.charAt(path.length()) == board[x][y]) || path.length()==0 ) {
            visited[x][y] = true;
            for(int i=0;i<4;i++) {
                path.append(board[x][y]);
                existDFS(board, s, x+points[i][0], y+points[i][1], visited, path);
                path.deleteCharAt(path.length()-1);                
            }
            visited[x][y] = false;
        }

    }

    public boolean exist(char[][] board, String word) {
        isFound = false;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(isFound) {
                        return true;
                    }
                    boolean visited[][] = new boolean [board.length][board[0].length];
                    existDFS(board, word,i,j,visited,new StringBuilder());
                }
            }
        }
        return isFound;
    }
}