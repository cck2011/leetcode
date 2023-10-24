//binary search
//final version
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
    int m = matrix.length, n = matrix[0].length;
    int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        
        if (equalOrSmaller(matrix,mid)<k) lo = mid + 1;
        else hi = mid;
        //low永遠會是最少達到count=k的數,
        //low少了 , count也會少了
        //low = mid+1
        //lo到位了,那count等於 count=k 後只會是hi減至return
        //所以low一定會在matrix中
    }
    return lo;
}
    
    
    public int equalOrSmaller(int[][] matrix, int x){
        int N = matrix.length;
        int col=N-1, r=0, count = 0;
        while (col>=0 && r<N)
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
}

//heap row solution
public class Solution {
public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
    //row length, input the first row
    for(int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j]));//x,y,val
    for(int i = 0; i < k - 1; i++) { // 小根堆，去掉 k - 1 個堆頂元素，此時堆頂元素就是第 k 的數
    //start from 0!!
        Tuple t = pq.poll();
        //remove the smallest element
        if(t.x == m - 1) continue;//coordinate used here
        //coutinue 提前結束本次循環，直接繼續執行下次循環
        //stop in the last line, will only poll in the last line
        pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
    }
    //poll one add one
    return pq.poll().val;
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x; this.y = y; this.val = val;
    }

    @Override
    //override leetcode method
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
}
//Comparator !

//heap column method
public class Solution {
public int kthSmallest(int[][] martix, int k){
        int col = martix.length;
        int row = martix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j=0; j<=col-1; j++)pq.offer(new Tuple(j,0,martix[j][0]));
        for(int i = 0; i<k-1;i++){
            Tuple t = pq.poll();
            if(t.y < col-1){
                pq.offer(new Tuple(t.x , t.y + 1, martix[t.x][t.y + 1]));
            }
            
            
        }
     return pq.poll().val;
    }
    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x; this.y = y; this.val = val;
        }

        @Override
        //override leetcode method
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}

class Solution { // 18 ms, faster than 32.44%
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, ans = -1; // For general, the matrix need not be a square
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int r = 0; r < Math.min(m, k); ++r)
            minHeap.offer(new int[]{matrix[r][0], r, 0});

        for (int i = 1; i <= k; ++i) {
            int[] top = minHeap.poll();
            int r = top[1], c = top[2];
            ans = top[0];
            if (c + 1 < n) minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }
        return ans;
    }
}

//Max heap

class Solution { // 14 ms, faster than 55.67%
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length; // For general, the matrix need not be a square
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                maxHeap.offer(matrix[r][c]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}

public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int lo = matrix[0][0], hi = matrix[m - 1][n - 1];

    
    while (lo <= hi) {//y =? because run one more time
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