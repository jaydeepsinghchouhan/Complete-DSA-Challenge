class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] flip = new int[image.length][image[0].length]; 
            for(int i=0;i<image.length;i++){
            int k=image[i].length-1;
            for(int j=0;j<image[i].length;j++){
                flip[i][j]=image[i][k]^1;
                k--;
            }
        }
        return flip;
    }
}