class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Move left since peak is on the left side or at mid
                end = mid;
            } else {
                // Move right since peak is on the right side
                start = mid + 1;
            }
        }
        return start; // or return end (both are same)
    }
}
