//This is a binary tree so left must smaller than root and right must be bigger than root
//Therefore, if root.val > R or root.val < L then root.val is smaller than low, 
//then go to root.right because when root is already smaller than Low, it's left must also be smaller than low
public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) return null;
    if (root.val > R) return trimBST(root.left, L, R);//if bigger than high then get left because when root is already bigger than high, it's right must also be bigger than high
    if (root.val < L) return trimBST(root.right, L, R);//if smaller than low then get right because when root is already smaller than Low, it's left must also be smaller than low
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
}



class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        //Find a valid root which is used to return.
        while (root.val < L || root.val > R) {
            if (root.val < L) {
                root = root.right;
            }
            if (root.val > R) {
                root = root.left;
            }
        }
        TreeNode dummy = root;
        // Remove the invalid nodes from left subtree.
        while (dummy != null) {
            while (dummy.left != null && dummy.left.val < L) {
                dummy.left = dummy.left.right; 
                // If the left child is smaller than L, then we just keep the right subtree of it. 
            }
            dummy = dummy.left;
        }
        dummy = root;
        // Remove the invalid nodes from right subtree
        while (dummy != null) {
            while (dummy.right != null && dummy.right.val > R) {
                dummy.right = dummy.right.left;
                // If the right child is biggrt than R, then we just keep the left subtree of it. 
            }
            dummy = dummy.right;
        }
        return root;
    }
}