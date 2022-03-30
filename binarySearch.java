public int normalBinarySearch(int[] nums, int key) {
    int l = 0, h = nums.length - 1;
    while (l <= h) {
        // l,h can equal, then m can be the same with l and h, m should be the answer
        int m = l + (h - l) / 2;// aviod overflow
        if (nums[m] == key) {
            return m;
        } else if (nums[m] > key) {//take left if mid >key
        //not >= key because = is already filtered
            h = m - 1;//no need to incule m becuase m is filtered
        } else {//take right if mid <key
            l = m + 1;
        }
    }
    return -1;
}

//variant of normal binary search
//do not know if key is vaild
public int variantBinarySearch(int[] nums, int key) {
    int l = 0, h = nums.length;
    while (l < h) {// if <= the loop will not stop because the stopping condition is l and h equal
        int m = l + (h - l) / 2;
        if (nums[m] >= key) {
            h = m;//do not -1 since inculded m
            //h = m then h is equal to key and stop loop and return
        } else {
            l = m + 1;
        }
    }
    return l;
}
12345 key = 2
l m h//m is caluated after h and l
1 3 5
1 2 3
1 1 2
2   2 //return l

key = 4
1 3 5
4 4 5
4   4//return 4

key = 5
1 3 5
4 4 5
5   5//return 5

key = 3
1 3 5
1 2 3
2 2 3
3   3//return 3