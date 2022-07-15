public int findSecondMinimumValue(TreeNode root) {
    if (root == null) return -1;
    if (root.left == null && root.right == null) return -1;

    int leftVal = root.left.val;
    int rightVal = root.right.val;

    if (root.val == leftVal) leftVal = findSecondMinimumValue(root.left);
    if (root.val == rightVal) rightVal = findSecondMinimumValue(root.right);

    if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
    if (leftVal != -1) return leftVal;
    return rightVal;
}

        1
   2(3)    2
3  3

   2
  / \
 2   5
   / \
    5  7

    class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null) return -1;
        
    //the downer of tree the smaller of nodes 

        int leftRes, rightRes;
        if (root.left.val == root.val) {// if == represent that may find smaller node
            leftRes = findSecondMinimumValue(root.left);
        } else { //if not == then there are no smaller node then leftRes = root.left.val;
            leftRes = root.left.val;
        }
        if (root.right.val == root.val) {
            rightRes = findSecondMinimumValue(root.right);
        } else {
            rightRes = root.right.val;
        }
        
        if (leftRes == -1 && rightRes == -1) return -1;
        else if (leftRes == -1) return rightRes;
        else if (rightRes == -1) return leftRes;
        else return Math.min(leftRes, rightRes);

    }
}