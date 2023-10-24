class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        
        while (start + 1 < end) {//if start dont +1 then if x = 8 start =2 end = 3, mid =2 will become infinit loop because mid = 2 + (3-2) / 2 = 2. ust be infinty loop in the last loop if not+1 in here or start = mid +1
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end == x) {//handle if x = 1, ans should be 1 but return 0
            return (int)end;
        }
        return (int)start;
    }
}



//Also ok
class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        if (x <= 1) {
        return x;
        }
        
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
       
        return (int)start;
    }
}

//Also ok

public int mySqrt(int x) {
    if (x <= 1) {
        return x;
    }
    int l = 1, h = x;
    while (l <= h) {
        int mid = l + (h - l) / 2;
        int sqrt = x / mid;//aviod overflow
        if (sqrt == mid) {// x/mid == mid    ==    x == mid*mid
            return mid;
        } else if (mid > sqrt) {
            h = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return h;
}

class Solution {
    public int mySqrt(int x) {
    if (x <= 1) {
        return x;
    }
    int l = 1, h = x;
    while (l <= h) {
        int mid = l + (h - l) / 2;
        int sqrt = x / mid;
        if (mid * mid == x) {
            return mid;
        } else if (mid * mid  > x) {
            h = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return h;//
}
}
//对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。

//my ans
class Solution {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        long start = 1;//long type or else overflow
        long end = x;
        while(start <= end){
            long mid = start + (end - start)/2;
            if(mid * mid == x){
                return (int)mid;
            }

            if( mid * mid > x ){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (int)end;
    }
}
//long type anther usage
class Solution {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid * mid == x){
                return mid;
            }

            if( (long)mid * mid > (long)x ){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }
}


//Time complexity:
// The time complexity of this approach is O(logN)O(logN)O(logN). It's very efficient because Binary Search reduces the search range by half in each iteration, making the search faster.

// Space complexity:
// The space complexity is O(1)O(1)O(1), which means the amount of extra memory used is constant, regardless of the input. We only use a few variables to store the search range and the middle value during the computation.