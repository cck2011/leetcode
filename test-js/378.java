//binary search
public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int lo = matrix[0][0], hi = matrix[m - 1][n - 1];

    
    while (lo <= hi) {//y =?
        int mid = lo + (hi - lo) / 2;
        int cnt = 0;
        //can find cnt even not sorted matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                //if number <= mid then count +1, 
                cnt++;
            }
        }
         //ensures count equals to k at a point
        if (cnt < k) lo = mid + 1;//right
        else hi = mid - 1;//left
        // reduce range to low equal to hi and high will be smaller than lo becuase hi = mid -1(left)
    }
    // if lo <= hi return
    return lo;
}
how to aviod not valid martix number