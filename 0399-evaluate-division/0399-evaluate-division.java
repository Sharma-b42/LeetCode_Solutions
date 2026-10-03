class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new Pair(b, val));
            graph.get(b).add(new Pair(a, 1.0 / val));
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                results[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(src, dst, graph, visited, 1.0);
            }
        }

        return results;
    }

    private double dfs(String curr, String target, Map<String, List<Pair>> graph, Set<String> visited, double product) {
        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (Pair neighbor : graph.get(curr)) {
            if (!visited.contains(neighbor.node)) {
                double result = dfs(neighbor.node, target, graph, visited, product * neighbor.weight);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    private static class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}