// Class to represent a job with profit and deadline
class Pair {
    int profit;
    int deadline;

    Pair(int profit, int deadline) {
        this.profit = profit;
        this.deadline = deadline;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = profit.length;
        int maxDeadline = 0;

        // Step 1: Build a list of jobs (profit, deadline)
        List<Pair> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Pair(profit[i], deadline[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Step 2: Sort jobs in descending order of profit
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 3: Array to track occupied time slots (size = maxDeadline)
        int[] slots = new int[maxDeadline];
        Arrays.fill(slots, -1);

        int totalProfit = 0;
        int jobsDone = 0;

        // Step 4: Place each job in the latest possible free slot
        for (Pair job : jobs) {
            int time = job.deadline;

            // Check from deadline-1 slot backwards
            while (--time >= 0) {
                if (slots[time] == -1) {
                    slots[time] = 1; // mark slot as filled
                    totalProfit += job.profit;
                    jobsDone++;
                    break; // move to next job
                }
            }
        }

        // Step 5: Build the answer [number of jobs, total profit]
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobsDone);
        result.add(totalProfit);

        return result;
    }
}
