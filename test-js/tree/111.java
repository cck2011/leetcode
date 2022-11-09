Class Solution{
    public integer shortestDepth(TreeNode root){
        if(root ==null)return 0;
        left = shortestDepth(root.left);
        right = shortestDepth(root.right);

        if(left == null || right == null)return left+right+1;//if one side is null or 0 then math.min will get 0, so to get the path that have node, must add two path
        return Math.min(left,right)+1;//if have both side node then Math.min to get shortest path
    }
}