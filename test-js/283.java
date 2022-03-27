public void moveZeroes(int[] nums) {
    int idx = 0;
    for (int num : nums) {
        if (num != 0) {
            nums[idx++] = num;
        }
    }
    //not eq 1
    //put in array and idx+1
    while (idx < nums.length) {
        nums[idx++] = 0;
    }
    
}