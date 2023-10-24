public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;//retrun if meet p or q but not keep travsal that node children because p and q must be exsist node and LCA(lowest commom ancestor) can be  p or q itself. So if another p and q is not found in the remain node, it must be under that p or q we first meet, then the p or q we first meet will be the answer(LCA)
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
    //if have left, then check right,  if right also exsist then return root
    //if have no left, return right
    //if have no right, return left
}