public int[] findErrorNums(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
         int n = nums.length
        //nums[i] != i + 1 ensure array number is ascending, prevent duplicate and lost number
        //nums[i]<=n is not essential but is template of index sorting, ensure nums are not bigger than n(both start from 0)
        //nums[nums[i] - 1] != nums[i] swap number can not be the same, or else infinite swap
        while (nums[i] != i + 1 && nums[i]<=n && nums[nums[i] - 1] != nums[i]) {
            //swap number to where it should be
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