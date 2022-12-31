class Solution {
    
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        getPaths(0, graph, new ArrayList<Integer>());
        return res;
    }
    
    private void getPaths(int pIdx,int[][] graph, List<Integer> lst){
        if(graph[pIdx]==null||graph[pIdx].length==0)return;
        lst.add(pIdx);
        int[] path = graph[pIdx];
        for(int p : path){
            if(p==graph.length-1){
                lst.add(p);
                res.add(new ArrayList<Integer>(lst));
                lst.remove(lst.size()-1);
            }else{
                getPaths(p, graph, lst);
            }
        }
        lst.remove(lst.size()-1);
    }
}