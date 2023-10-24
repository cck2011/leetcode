public int[] searchRange(int[] nums, int target) {
    int first = findFirst(nums, target);
    int last = findFirst(nums, target + 1) - 1;
    if (first == nums.length || nums[first] != target) {//wrong when i m trying, forget first == nums.length.
        return new int[]{-1, -1};
    } else {
        return new int[]{first, Math.max(first, last)};
    }
}

private int findFirst(int[] nums, int target) {
    int l = 0, h = nums.length; // 注意 h 的初始值  wrong when i m trying do this because int last = findFirst(nums, target + 1) - 1; cannot find the next index of target if target is the last one.
    while (l < h) {
        int m = l + (h - l) / 2;
        if (nums[m] >= target) {// wrong when i m trying, is >=, m can be target
            h = m;//?
        } else {
            l = m + 1;
        }
    }
    return l;
}
//577888
//if (first == nums.length || nums[first] != target) only 
//two situation need to return -1, -1:
// target 在 nums[0] ~ nums[n-1] 中，nums 中不存在 target。例如 nums = [5,7,7,8,8,10]，target = 6，返回 [-1,-1]。
// target < nums[0] 或者 target > nums[n-1]。例如 nums = [5,7,7,8,8,10], target = 4，返回 [-1,-1]。
//first == nums.length can filter empty nums, target > nums[n-1]. nums[first] != target filter target < nums[0] and target not in nums.

// if (nums[m] >= target) {
//             h = m;
//         } else {
//             l = m + 1;
//         }

//need to find the smallest one in the same element. 
//if 1223, target = 2
//h=2 position is 2 which is the ans so cannot exclude
//and because need to find the smallest element which is on the left side,
//cannot:
// if (nums[m] <= target) {
//        l = m;
//     } else {
//         h = m - 1 ;
//     }

//if do not want to exclude ans, 
// if (nums[m] >= target) {
//             h = m;
//         } else {
//             l = m + 1;
//         }



// 如果 h 的取值为 nums.length - 1，那么 last = findFirst(nums, target + 1) - 1 = 1 - 1 = 0。这是因为 findLeft 只会返回 [0, nums.length - 1] 范围的值
// ，对于 findFirst([2,2], 3) ，我们希望返回 3 插入 nums 中的位置，也就是数组最后一个位置再往后一个位置，即 nums.length。所以我们需要将 h 取值为 nums.length
// ，从而使得 findFirst返回的区间更大，能够覆盖 target 大于 nums 最后一个元素的情况。

class Solution {

    public int leftMargin(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] == target){
                high = mid - 1;
            }
        }
        if (nums[low] == target) {
            return low;
        } else {
            return -1;
        }
    }
    public int rightMargin(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int rm = -2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] == target){
                low = mid + 1;
                rm = low;
            }
        }
        if (nums[high] == target) {
            return high;
        } else {
            return -1;
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[] {-1,-1};
        }
        int lm = leftMargin(nums,target);
        int rm = rightMargin(nums,target);
        return new int[] {lm,rm};
    }
}

作者：编程文青李狗蛋
链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/1250864/acm-xuan-shou-tu-jie-leetcode-zai-pai-xu-yz1m/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。