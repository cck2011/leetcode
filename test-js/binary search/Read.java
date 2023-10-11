

public int binarySearch(int[] nums, int key) {
    int l = 0, h = nums.length - 1;
    while (l <= h) {
        int m = l + (h - l) / 2;
        if (nums[m] == key) {
            return m;
        } else if (nums[m] > key) {
            h = m - 1;
        } else {
            l = m + 1;
        }
    }
    return -1;
}

// m 计算

// 有两种计算中值 m 的方式：

// m = (l + h) / 2
// m = l + (h - l) / 2
// l + h 可能出现加法溢出，也就是说加法的结果大于整型能够表示的范围。但是 l 和 h 都为正数，因此 h - l 不会出现加法溢出问题。所以，最好使用第二种计算法方法


// overflow means that the number of variable is over the limit of the type of variable eg.int



public int binarySearch(int[] nums, int key) {
    int l = 0, h = nums.length;
    while (l < h) { //if l == h then return l which is the ans, otherwise infinity loop
        int m = l + (h - l) / 2;
        if (nums[m] >= key) {// m maybe the ans
            h = m;//shoud not exclude the ans
        } else {
            l = m + 1;
        }
    }
    return l;//because need to return the ans on the left , the while loop will finally go to the left of the ans
}