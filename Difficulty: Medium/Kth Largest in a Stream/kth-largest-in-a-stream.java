class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // PriorityQueue in Java is a Min-Heap by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            pq.add(num);

            // If heap size exceeds k, remove the smallest element
            if (pq.size() > k) {
                pq.poll();
            }

            // If we have fewer than k elements, add -1 to result
            if (pq.size() < k) {
                result.add(-1);
            } else {
                // The root of the min-heap is the kth largest element
                result.add(pq.peek());
            }
        }

        return result;
    }
}