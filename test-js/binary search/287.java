//binary search other method maybe better in interview
//number is unque within 1 - n
//therefore if repeat then count of it will be bigger than the other range
public int findDuplicate(int[] nums) {
     int l = 1, h = nums.length - 1;
     while (l <= h) {
         int mid = l + (h - l) / 2;
         int cnt = 0;
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] <= mid) cnt++;
         }
         if (cnt > mid) h = mid - 1;
         else l = mid + 1;
     }
     return l;
}
//range = n.length -1 represent the range of number

//13422
//l=1 h=4
//m=2
//if count of 2 > 2 then there must be repeated num within  1 and 2
//https://www.bilibili.com/video/BV1eT411u7oD/?spm_id_from=333.999.0.0&vd_source=8d4c0bb6f04271cbe95d70f568c88555

//other method
//https://leetcode.cn/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
//https://leetcode.com/problems/find-the-duplicate-number/solutions/1892921/9-approaches-count-hash-in-place-marked-sort-binary-search-bit-mask-fast-slow-pointers/