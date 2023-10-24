public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> numsCnt = new HashMap<>();//count number
    Map<Integer, Integer> numsLastIndex = new HashMap<>();//index of num last occur
    Map<Integer, Integer> numsFirstIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);//+1 count if exsist
        numsLastIndex.put(num, i);
        if (!numsFirstIndex.containsKey(num)) {//if have no this key
            numsFirstIndex.put(num, i);
        }
    }
    int maxCnt = 0;
    for (int num : nums) {
        maxCnt = Math.max(maxCnt, numsCnt.get(num));
    }//maxount is count number
    int ret = nums.length;
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        int cnt = numsCnt.get(num);
        if (cnt != maxCnt) continue;
        //if have the same maxCnt, then get the num with smaller result(Math.min)
        ret = Math.min(ret, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
                        7                   6      -                    1      +1 = 6
                        //why +1
    }
    return ret;
}

    public int findShortestSubArray(int[] A) {
        Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0;
        for (int i = 0; i < A.length; ++i) {
            first.putIfAbsent(A[i], i);
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
            if (count.get(A[i]) > degree) {
                degree = count.get(A[i]);
                res = i - first.get(A[i]) + 1;
            } else if (count.get(A[i]) == degree)
                res = Math.min(res, i - first.get(A[i]) + 1);
        }
        return res;
    }

    // math.max time complexity is O(1), so 
    // if (count.get(A[i]) > degree) {     to
    //  if (count.get(A[i]) >= degree) {
    // then math.min everytime is ok too
    // example if else statement is just for clearly
     public int findShortestSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
           if (!map.containsKey(nums[i])){ //if do not contain key
               map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
           } else {//if contain
               int[] temp = map.get(nums[i]);
               temp[0]++;
               temp[2] = i;
           }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE; //degree is count, interger.min_value is the smallest integer
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            } 
        }
        return res;
    }