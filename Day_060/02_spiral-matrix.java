class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>ls = new ArrayList();
        int row = matrix.length;
        if(row == 0) {
            return ls;
        }
        int col = matrix[0].length;
        
        int t=0, b=row-1, l=0, r=col-1, d=0;
        
        while(l<=r && t<=b) {
            if(d==0) {
                for(int i=l; i<=r; i++) {
                    ls.add(matrix[t][i]);
                }
                d=1;    t++;
            }
            else if(d==1) {
                for(int i=t; i<=b; i++) {
                    ls.add(matrix[i][r]);
                }
                d=2;    r--;
            }
            else if(d==2) {
                for(int i=r; i>=l; i--) {
                    ls.add(matrix[b][i]);
                }
                d=3;    b--;
            }
            else if(d==3) {
                for(int i=b; i>=t; i--) {
                    ls.add(matrix[i][l]);
                }
                d=0;    l++;
            }
        }
        return ls;
    }
}