public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
//should understand as return Math.max(maxDepth(1), maxDepth(0))+1

  2
1   3
//DFS Depth-first Search
public int maxDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }
    
    Stack<TreeNode> stack = new Stack<>();// stack is last in first out
    Stack<Integer> value = new Stack<>();
    stack.push(root);//root first
    value.push(1);
    int max = 0;
    while(!stack.isEmpty()) {
        TreeNode node = stack.pop();
        int temp = value.pop();
        max = Math.max(temp, max);//?y not just +1
        if(node.left != null) {//left immdeately push to stack?
            stack.push(node.left);
            value.push(temp+1);
        }
        if(node.right != null) {
            stack.push(node.right);
            value.push(temp+1);
        }
    }
    return max;
}

//BFS Breadth-first Search
