class Solution {
   
    public int ncr(int n,int r)
    {
        int ans=1;
        for(int i=1;i<=r;i++)
        {
            ans=ans*(n-i+1)/i;
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
               temp.add(ncr(i,j));
            }
            arr.add(temp);
        }
        return arr;
    }
}