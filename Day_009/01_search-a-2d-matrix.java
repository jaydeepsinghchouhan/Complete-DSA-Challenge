class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int st = 0;
        int end = matrix.length *matrix[0].length -1;
        int mid;
        while(st<=end) {
            mid = st +(end-st)/2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length] == target) {
                return true;
            }
            else if(matrix[mid/matrix[0].length][mid%matrix[0].length]>target) {
                end = mid-1;
            }
            else {
                st = mid +1;
            }
        }
        return false;
    }
}