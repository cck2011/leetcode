public int[] findErrorNums(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        //nums[i] != i + 1 ensure array number is ascending, prevent duplicate and lost number
        //nums[nums[i] - 1] != nums[i] 
        while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
            swap(nums, i, nums[i] - 1);
        }
    }
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return new int[]{nums[i], i + 1};
        }
    }
    return null;
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}