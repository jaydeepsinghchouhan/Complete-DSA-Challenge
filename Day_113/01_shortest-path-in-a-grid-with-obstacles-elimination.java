class Solution {
    int[][] arr;//just a reference variable to get size of supplied array.
    boolean inRange(int i,int j){//helps in finding out if the request is out of bound or not.
        //arr used here
        return i>=0&&i<arr.length && j>=0 && j<arr[0].length;
    }
    public int shortestPath(int[][] grid, int k) {
        //stores the state of current branch's head. {i,j,k,cost}
        int[] state=new int[]{0,0,k,0};
        arr=grid;
        int[] v={0,0,1,-1};//possible verticle movements
        int[] h={1,-1,0,0};//"" horizontal ""
        //visited array store the maximum bombs left yet in reaching this location. 
        int[][] visited=new int[grid.length][grid[0].length];
        for(int[] arr:visited){
            Arrays.fill(arr,Integer.MIN_VALUE);//populating with Integer.MIN_VALUE as there may be chances we never reach that location.
        }
        //queue to acheave our bfs
        Queue<int[]> q=new LinkedList<>();
        q.add(state);
        while(!q.isEmpty()){
            state=q.poll();
            //extracting values from the state
            int a=state[0],b=state[1],bomb=state[2],val=state[3];
            if(a==grid.length-1&&b==grid[0].length-1) return val;
            //this is a crucial arguments as prevent us from taking any bad decision.
            if(visited[state[0]][state[1]]>=state[2]) continue;
            //no state visited the location yet hence adding
            visited[state[0]][state[1]]=state[2];
            for(int i=0;i<4;i++){
                //checking if the request is in range or not
                if(inRange(a+v[i],b+h[i])){
                    //if hit the wall with no bombs left stop the branch expension.
                    if(grid[a+v[i]][b+h[i]]==1&&bomb<=0) continue;
                    //if have bomb move aheading by spending one bomb
                    if(grid[a+v[i]][b+h[i]]==1){
                     q.add(new int[]{a+v[i],b+h[i],bomb-1,val+1});
                    }
                    else{
                        //no need of bomb guys calm down
                        q.add(new int[]{a+v[i],b+h[i],bomb,val+1});
                    }
                }
            }
        }
        return -1;
    }
}