public int singleNonDuplicate(int[] nums) {
    int l = 0, h = nums.length - 1;
    while (l < h) {
        int m = l + (h - l) / 2;
        if (m % 2 == 1) {
            m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数 cannot m++
        }
        if (nums[m] == nums[m + 1]) {
            l = m + 2;
        } else {
            h = m;//should not exclude h 233 2 is ans
        }
    }
    return nums[l];
}
//[3,3,7,7,10,11,11] if h = m-2 then will exclude h is the ans
//12233
// 1 1 2 3 3
//
//if mid is even then  different from the front node, need to check the next node
//if mid is odd then different from the next node , check the previous node

//令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
//如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；
//if mid is even and ans > mid +1 then ans is at the back of ans, and without ans, the number in array is all in pair, so nums[m] == nums[m + 1]

//good explaination
// https://leetcode.cn/problems/single-element-in-a-sorted-array/solution/gong-shui-san-xie-er-duan-xing-fen-xi-yu-17nv/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (mid % 2 == 0) {
                if ( nums[mid] == nums[mid + 1]) l = mid + 1;
                else r = mid;
            } else {
                if ( nums[mid - 1] == nums[mid]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[r];// return r and l is also ok because r and l will finally be the same then quit the loop
    }
}

