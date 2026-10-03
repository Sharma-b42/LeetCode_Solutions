class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            graph.get(c[0]).add(new int[]{c[1], 1});
            graph.get(c[1]).add(new int[]{c[0], 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] edge : graph.get(node)) {
            int neighbor = edge[0];
            int cost = edge[1];
            if (!visited[neighbor]) {
                count += cost;
                count += dfs(neighbor, graph, visited);
            }
        }

        return count;
    }
}