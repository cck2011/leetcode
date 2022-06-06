public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;//if both null
    if (t1 == null) return t2;//if one child is null
    if (t2 == null) return t1;
    TreeNode root = new TreeNode(t1.val + t2.val);//if both have children then create a new node
    root.left = mergeTrees(t1.left, t2.left);//go end of t1 and t2, assign to root.left
    root.right = mergeTrees(t1.right, t2.right);//assign to root.right
    return root;
}

 t1            t2
   2            2
 1   3         2  4
2      
process: 
return root
root.right = mergeTrees(root)
root.left = mergeTrees(root)
root.left = mergeTrees(t1)
TreeNode root = new TreeNode(t1.val + t2.val);