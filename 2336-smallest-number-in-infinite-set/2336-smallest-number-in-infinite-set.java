class SmallestInfiniteSet {
    private int next;
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> inHeap;

    public SmallestInfiniteSet() {
        next = 1;
        minHeap = new PriorityQueue<>();
        inHeap = new HashSet<>();
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            inHeap.remove(smallest);
            return smallest;
        }
        return next++;
    }

    public void addBack(int num) {
        if (num < next && !inHeap.contains(num)) {
            minHeap.offer(num);
            inHeap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */