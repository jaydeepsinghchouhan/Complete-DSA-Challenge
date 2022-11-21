class Pair
{
    int row;
    int col;
    int cnt;
    public Pair(int r,int c,int cnt)
    {
        this.cnt=cnt;
        row=r;
        col=c;
    }
}
class Solution 
{
    public int nearestExit(char[][] maze, int[] entrance) 
    {
        int rowEnd=maze.length-1;
        int colEnd=maze[0].length-1;
        Queue<Pair> q=new LinkedList();
        int[] dr={0,+1,0,-1};
        int[] dc={+1,0,-1,0};
        q.offer(new Pair(entrance[0],entrance[1],0));
        boolean[][] vis=new boolean[rowEnd+1][colEnd+1];
        vis[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty())
        {
            Pair top=q.poll();
            int row=top.row;
            int col=top.col;
            int cnt=top.cnt;
            for(int i=0;i<4;i++)
            {
                int nextRow=row+dr[i];
                int nextCol=col+dc[i];
                if(nextRow>=0 && nextRow<=rowEnd && nextCol>=0 && nextCol<=colEnd && maze[nextRow][nextCol]=='.' && !vis[nextRow][nextCol])
                {
                    if(nextRow==0 || nextRow==rowEnd || nextCol==0 || nextCol==colEnd)  return cnt+1;
                    vis[nextRow][nextCol]=true;
                    q.offer(new Pair(nextRow,nextCol,cnt+1));
                }
            }
        }
        
        return -1;
    }
}