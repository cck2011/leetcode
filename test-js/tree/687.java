private int path = 0;

public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return path;
}

private int dfs(TreeNode root){
    if (root == null) return 0;
    int left = dfs(root.left);
    int right = dfs(root.right);
    int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
    int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
    path = Math.max(path, leftPath + rightPath);
    return Math.max(leftPath, rightPath);
}

class Solution {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestPath(root);
        return ans;
    }
    //递归函数功能：搜寻以node为起点的最长同值路径:要么是以node为起点的左子树，要么是以node为起点的右子树
    public int longestPath(TreeNode node) {
        if (node == null) return 0;
        int maxLorRres=0;
        int left = longestPath(node.left); //node左子树的最长同值路径
        int right = longestPath(node.right);//node右子树的最长同值路径
        //这种情况对于寻找最长同值路径长有帮助，对于搜索以root为路径起始点的最长路径没有帮助
        if (node.left != null && node.left.val == node.val&&node.right != null && node.right.val == node.val) {
            ans=Math.max(ans, left + right+2);
        }
        //从左右子树中选择最长的同值路径
        if(node.left!=null&&node.left.val == node.val){
            maxLorRres=left+1;
        }
        if(node.right!=null&&node.right.val==node.val){
            maxLorRres=Math.max(maxLorRres,right+1);
        }
        //从ans与maxLorRres中更新最大值
        ans=Math.max(ans,maxLorRres);
        return maxLorRres; //because to accumlate left and right +1, can only return one path
    }//return one path to see if there is node in the upper level can make longest path with same value
//it is not one path if return ans
}

作者：Chuancey
链接：https://leetcode.cn/problems/longest-univalue-path/solution/guan-yu-di-gui-si-lu-de-chao-xiang-xi-ge-ren-jian-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。