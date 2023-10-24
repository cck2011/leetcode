class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;                /* 左闭右闭区间，如果用右开区间则不方便判断右值 */ 
        while (left < right) {                      /* 循环不变式，如果left == right，则循环结束 */
            int mid = left + (right - left) / 2;    /* 地板除，mid更靠近left */
            if (nums[mid] > nums[right]) {          /* 中值 > 右值，最小值在右半边，收缩左边界 */ //small in right
                left = mid + 1;                     /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
            } else if (nums[mid] < nums[right]) {   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */ //small in left
                right = mid;                        /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */ 
            }
        }
        return nums[left];    /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */     
    }
};


// 再分析一下while循环退出的条件。 while (left < right)

// 如果输入数组只有一个数，左右边界位置重合，left == right，不会进入while循环，直接输出。

// 如果输入数组多于一个数，循环到最后，会只剩两个数，nums[left] == nums[mid]，以及nums[right]，这里的位置left == mid == right - 1。

// 如果nums[left] == nums[mid] > nums[right]，则左边大、右边小，
// 需要执行left = mid + 1，使得left == right，左右边界位置重合，循环结束，nums[left]与nums[right]都保存了最小值。

// 如果nums[left] == nums[mid] < nums[right]，则左边小、右边大，
// 会执行right = mid，使得left == right，左右边界位置重合，循环结束，nums[left]、nums[mid]、nums[right]都保存了最小值。



// 12345 nums[mid] < nums[right] right = mid; 123 right = mid 12 right = mid 1
// 51234 nums[mid] < nums[right] right = mid; 512 right = mid 51 nums[mid] > nums[right] 1
// 45123 nums[mid] < nums[right] right = mid; 451 left = mid + 1 1
// 34512 nums[mid] > nums[right] left = mid + 1 12 right = mid 1
// 23451 nums[mid] > nums[right] left = mid + 1 51 left = mid + 1 1

//why when nums[mid] > nums[right]  small in right?
//nums[mid] < nums[right] small in left

// three situation only

左值 < 中值, 中值 < 右值 ：没有旋转，最小值在最左边，可以收缩右边界

        右
     中
 左
左值 > 中值, 中值 < 右值 ：有旋转，最小值在左半边，可以收缩右边界 //right = mid not exculding mid because mid is the smallest in this situation

         右
 左 
     中
左值 < 中值, 中值 > 右值 ：有旋转，最小值在右半边，可以收缩左边界//left = mid + 1 mid already bigger than right, no need to exclude mid

     中  
 左 
         右



https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/