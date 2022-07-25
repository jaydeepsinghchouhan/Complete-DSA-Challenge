class Solution {
    
    public void result(int ind,int [] arr, int target, List<List<Integer>> res, List<Integer> ds){
        if(arr.length == ind){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
             
            return;
        }
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            result(ind, arr, target - arr[ind], res, ds);
            ds.remove(ds.size() - 1);  // if the arr ends and the target is not reached
			                           //then we would have to remove the Last entered array in the ds
        }
        result(ind+1, arr, target, res,ds);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        result(0, candidates, target, res, new ArrayList<>());
        return res;
    }
}