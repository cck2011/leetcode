//I want to find the min number that is bigger than the smallest number
//need to know about the condition before thinking the recursion
//if children are the same with root then may have bigger value
//if children are both not equal then must be two bigger value,then should get the min of them
public int findSecondMinimumValue(TreeNode root) {
    if (root == null) return -1;
    if (root.left == null && root.right == null) return -1;//already handle both -1 because this situation will only happen when there are only two level of tree(root and children)
// the children of root must be smaller than children
    int leftVal = root.left.val;
    int rightVal = root.right.val;
//if equal then go in to see if there are bigger number
    if (root.val == leftVal) leftVal = findSecondMinimumValue(root.left);
    if (root.val == rightVal) rightVal = findSecondMinimumValue(root.right);
    //do it when return after traversal
    //when there is not equal
    if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);//why wont it always return the smallest
    if (leftVal != -1) return leftVal;
    return rightVal;
}//where do it handle both -1?

        1
   2(3)    2
3  3

   2
  / \
 2   2
   / \
   2  7
   /\
   2 3

   2
  / \
 2   5
    / \
    5  7
//easier to understand
    class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null) return -1;//hadnle have no root and that root have no children(question said that if have children that must have two children)
        
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
        
        if (leftRes == -1 && rightRes == -1) return -1;//only one number
        else if (leftRes == -1) return rightRes;
        else if (rightRes == -1) return leftRes;
        else return Math.min(leftRes, rightRes);

    }
}