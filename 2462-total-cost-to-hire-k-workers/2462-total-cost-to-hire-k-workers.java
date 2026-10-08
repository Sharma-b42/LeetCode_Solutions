class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int i = 0;
        int j = costs.length - 1;
        long total = 0;

        for (int count = 0; count < candidates && i <= j; count++) {
            left.offer(costs[i++]);
        }
        for (int count = 0; count < candidates && i <= j; count++) {
            right.offer(costs[j--]);
        }

        for (int hired = 0; hired < k; hired++) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                total += left.poll();
                if (i <= j) {
                    left.offer(costs[i++]);
                }
            } else {
                total += right.poll();
                if (i <= j) {
                    right.offer(costs[j--]);
                }
            }
        }

        return total;
    }
}