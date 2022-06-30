class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> lstack = new Stack<>();
        Stack<TreeNode> rstack = new Stack<>();

        if (root.left != null) lstack.push(root.left);
        if (root.right != null) rstack.push(root.right);

        while(!lstack.isEmpty() && !rstack.isEmpty()){
            TreeNode lvalue = lstack.pop();
            TreeNode rvalue = rstack.pop();

            if(lvalue !=rvalue)return false;

            if (lvalue.left != null)lstack.push(lvalue.left);
            if (lvalue.right != null)lstack.push(lvalue.right);
            if(lstack.size() != rstack.size())return false;
            if (rvalue.right != null)rstack.push(rvalue.right);
            if (rvalue.right != null)rstack.push(rvalue.left);
            if(lstack.size() != rstack.size())return false;
            

        }
        return lstack.size() == rstack.size();
    }
}