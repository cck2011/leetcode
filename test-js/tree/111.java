Class Solution{
    public integer shortestDepth(TreeNode root){
        if(root ==null)return 0;
        left = shortestDepth(root.left);
        right = shortestDepth(root.right);

        if(left == null || right == null)return left+right+1;
        return Math.min(left,right)+1;
    }
}