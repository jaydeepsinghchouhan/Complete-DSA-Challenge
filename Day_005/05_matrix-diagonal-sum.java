class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int j = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            sum += (mat[i][i] + mat[i][j]);
            j--;
        }
        if ( mat.length % 2 != 0 ) {
            int l = mat.length / 2;
            sum -= mat[l][l];
        }
        return sum;
    }
}