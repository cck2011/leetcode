//in this question what i only need to know is what is the end condition of recursion and wt the recurstion need to process
//the recursion need to process: compare in_root and without_root to return the bigger
// and add two node if the node have two children
//adding node value in in_root
//(O)n time and space complexity for the  optimize method(map)
Map<TreeNode, Integer> cache = new HashMap<>(); 

public int rob(TreeNode root) {
    if (root == null) return 0;
    if (cache.containsKey(root)) return cache.get(root);//prevent caluating root.left and root.right
    int in_root = root.val;
    if (root.left != null) in_root += rob(root.left.left) + rob(root.left.right);
    if (root.right != null) in_root += rob(root.right.left) + rob(root.right.right);
    int without_root = rob(root.left) + rob(root.right);
    int res = Math.max(in_root, without_root);//get bigger of sum of with root and without root, because answer can be not in one level of tree(eg. left path is with root and right path is without root.)
    cache.put(root, res);
    return res;
}//caluate all node in_root and without_root and get and bigger of both, then go up one level and do it again
// can be like this, but repeat caluate root.left and root.right
class Solution
    def rob(self, root: TreeNode) -> int:
        if not root:
            return 0
        # 分情况
        # 偷窃根节点 与 不偷窃根节点
        in_root = root.val
        if root.left:
            # 偷窃根节点时，无法偷取子节点，那么偷窃子孙节点
            in_root += self.rob(root.left.left) +self. rob(root.left.right)
        if root.right:
            in_root += self.rob(root.right.left) +self. rob(root.right.right)
        
        # 不偷取根节点，那么收益就是左右子节点权值的总和
        not_in_root = self.rob(root.left) + self.rob(root.right)

        # 返回大值
        return max(in_root, not_in_root)

        上面這段代碼執行後超時，因為在計算子孫節點的時候，計算了根節點下的左右子樹，而後續計算又重複計算了子孫節點。
        在這裡，我們來進行優化，將計算後的結果存儲到哈希表中，遇到需要重複計算的部分，直接拿過來，不需要再次遞歸計算。