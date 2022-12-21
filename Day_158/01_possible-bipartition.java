class Solution {
   public boolean possibleBipartition(int n, int[][] dislikes) {
  List<Integer>[] graph = new ArrayList[n + 1];
  for (int i = 1; i <= n; i++) {
    graph[i] = new ArrayList<>();
  }

  for (int[] dislike : dislikes) {
    graph[dislike[0]].add(dislike[1]);
    graph[dislike[1]].add(dislike[0]);
  }

  int[] colors = new int[n + 1];

  for (int node = 1; node <= n; node++) {
    if (colors[node] == 0) {
      colors[node] = 1;

      if (!dfs(colors, node, graph)) {
        return false;
      }
    }
  }

  return true;
}

private boolean dfs(int[] colors, int person, List<Integer>[] graph) {
  for (int p : graph[person]) {
    if (colors[person] == colors[p]) {
      return false;
    }

    if (colors[p] == 0) {
      colors[p] = -colors[person];

      if (!dfs(colors, p, graph)) {
        return false;
      }
    }
  }

  return true;
}
}