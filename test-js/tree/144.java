public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();//pop stack (last in)
        if (node == null) continue;//stack can push and pop null
        ret.add(node.val);
        stack.push(node.right);  // 先右后左，保证左子树先遍历 last in first out, so left will be first out
        stack.push(node.left);
    }
    return ret;
}//pop left then hit null then pop the second last (right)

class Solution{
    public List<Integer> list = new ArrayList();
    Stack<TreeNode> stack = new Stack();
    while(!stack.isEmpty() || root != null){
    while(root != null){//if null not eq to null then push to the end of left
        list.add(root.val);
        stack.push(root);//end of left
        root = root.left;
    }
    root = stack.pop();//if root is null then go up one level and go right
    root = root.right;
    }
    return list;
}