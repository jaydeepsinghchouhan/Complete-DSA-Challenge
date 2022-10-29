class Solution {
    class Node {
        int pt, gt;
        public Node(int pt, int gt) {
            this.pt = pt;
            this.gt = gt;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(plantTime[i], growTime[i]);
        }
        Arrays.sort(arr, (a, b) -> a.gt == b.gt ? a.pt - b.pt : b.gt - a.gt);
        int endTime = 0;
        int lastPlantTime = 0;
        for (Node node : arr) {
            lastPlantTime += node.pt;
            endTime = Math.max(endTime, lastPlantTime + node.gt);
        }
        return endTime;
    }
}