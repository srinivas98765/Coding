class Solution {

    boolean subsetSumToK(int n, int k, int[] arr) {

        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[ind] <= target)
                    take = prev[target - arr[ind]];
                curr[target] = take || notTake;
            }
            prev = curr;
        }

        return prev[k];
    }

    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for (int num : nums) totSum += num;
        if (totSum % 2 != 0) return false;
        int target = totSum / 2;
        return subsetSumToK(nums.length, target, nums);
    }
}
