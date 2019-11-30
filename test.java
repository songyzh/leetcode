class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; ++i) {
            int val = nums[i];
            if (val == 0) {
                swap(nums, i, left++);
            } else if (val == 2) {
                swap(nums, i--, right--);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}