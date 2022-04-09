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


class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) 
    {
        int N = matrix.size();
        int left = matrix[0][0];
        int right = matrix[N-1][N-1];
        while (left<right)
        {
            int mid = left+(right-left)/2;
            //cout<<left<<" "<<right<<" "<<mid<<" "<<equalOrSmaller(matrix,mid)<<endl;
            
            if (equalOrSmaller(matrix,mid)<k)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
    
    int equalOrSmaller(vector<vector<int>>& matrix, int x)
    //seperate by middle and get number lower than middle
    //start from right top corner and if <= then get all count of that row
    //can get even if have duplicate number
    {
        int N = matrix.size();
        int col=N-1, r=0, count = 0;
        while (col>=0 && r<N)//col cannot lower than zero and r cannot higher than N
        {
            if (matrix[col][r]<=x)
            {
                count+=(col+1);
                r++;
            }
            else
                col--;                
        }
        return count;
    }
};