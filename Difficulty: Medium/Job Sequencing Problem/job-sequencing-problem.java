import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static class Job {
        int deadline;
        int profit;

        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        // 1. Sort jobs primarily by deadline ascending
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.deadline, b.deadline));

        // 2. Min-Heap to store the profits of accepted jobs
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Job job : jobs) {
            // If we have available time slots before this deadline
            if (job.deadline > minHeap.size()) {
                minHeap.offer(job.profit);
            } 
            // Otherwise, replace the lowest profit job if this one pays more
            else if (!minHeap.isEmpty() && job.profit > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(job.profit);
            }
        }

        int countJobs = minHeap.size();
        int maxProfit = 0;

        while (!minHeap.isEmpty()) {
            maxProfit += minHeap.poll();
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(maxProfit);
        return result;
    }
}