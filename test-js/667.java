public int[] constructArray(int n, int k) {
    int[] ret = new int[n];
    ret[0] = 1;
    for (int i = 1, interval = k; i <= k; i++, interval--) {
        ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
    }
    for (int i = k + 1; i < n; i++) {
        ret[i] = i + 1;
    }
    return ret;
}
//k cannot be biger than n
//First, get the required interval number
//interval is the difference of number
//get the biggest number in the interval number(k)
//if n = 7, k = 5, then the number would be 6 (1,6,2,5,3,4,7), i mean (1, and then 6),6-1 = 5, 
//so have 5 interval 5,4,3,2,1
//previous +interval and -interval
//interval-- to reduce the interval differnece -1 each

//Second, for loop the rest of the number from k+1