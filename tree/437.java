class Solution{
    public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;
    int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    //                 root                           left of root          rigth of root
    return ret;
}

private int pathSumStartWithRoot(TreeNode root, int sum) {
    if (root == null) return 0;
    int ret = 0;
    if (root.val == sum) ret++;//run from top to button and already store data
    ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);//up to button
    return ret;//return from button to top
}
2022-06-10-11-39-46.png
}
      10           target = 8
   5    -3   
3    2    11
       1 
//pathSumStartWithRoot is to find root to leaf path's number
//then go to pathSum recursion to traversal all nodes and run pathSumStartWithRoot to check every node path number



public Solution{
     public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);//handle if root and target is equal,  take care root node???
        //if no extra path left, then currSum -target is 0. In this case, res will also +1
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;//curSum + target = Path
        int res = preSum.getOrDefault(currSum - target, 0);//sum of traversaled node - target
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);//put curSumPath into hashmap
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);//to ignore node that are counted?
        return res;
    }
}
https://www.youtube.com/watch?v=uZzvivFkgtM
 t1           
     10           target = 8
   5    -3   
3    2    11
       1 
        current sum history
       0:1   
       10:1
       15:1
       18:1

       10


     1
    2  -1
  -1  2
//not recursion in recursion, only traversal once
   class Solution {
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        //get in if node.left and node.right = null, then current node path from hashmap
        //then the node will return up one level and try to find it right node
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }
}
t1           
     10           target = 8
   5    -3   
3    2    11
       1 
       node value 10
       currSum 10

  /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param node 树节点
     * @param prefixSumCount 前缀和Map
     * @param target 目标值
     * @param currSum 当前路径和
     * @return 满足题意的解
     */


时间复杂度：每个节点只遍历一次,O(N).

空间复杂度：开辟了一个hashMap,O(N).

class Solution{
    public int findTargetPathSum(TreeNode root, int target){
        Map<Integer, Integer> Map = new HashMap<>();
        Map.put(0,1);
        return recursionPathSum(root, Map, target, 0);
    }
    public int recursionPathSum(TreeNode node, Map<Integer, Integer> map, int target, int curSum){
        if (node == null) {
            return 0;
        }
        int res = 0;
        curSum += node.val;
        res += map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum,0)+1);
        res += recursionPathSum(node.left, map, target, curSum);
        res += recursionPathSum(node.right, map, target, curSum);
        //is other also + two function
        //come in because have no children
        map.put(curSum,map.get(curSum)-1);
        return res;
        }
}