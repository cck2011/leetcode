public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
//should understand as return Math.max(maxDepth(1), maxDepth(0))+1

  2
1   3
//DFS Depth-first Search
//DFS use stack becasue last in first out can track the current node
//time complexity O(|V|), you need to traverse all nodes.
//Space complexity - a recursive implementation can have a O(h) space complexity [worst case], where h is the maximal depth of your tree.
//dfs include inorder preorder and postorder
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
        if(node.left != null) {
            stack.push(node.left);
            value.push(temp+1);//same number if in same level
        }
        if(node.right != null) {
            stack.push(node.right);//push left and right at the same time if have two children
            value.push(temp+1);
        }
    }
    return max;
}
    1
  2   3  //both temp = 2
//https://www.youtube.com/watch?v=hTM3phVI6YQ

//BFS Breadth-first Search
//BFS use queue becasue first in first out, good for poping upper layer
//Time complexity is O(|V|), where |V| is the number of nodes. You need to traverse all nodes.
//Space complexity is O(|V|) as well - since at worst case you need to hold all vertices頂點 in the queue.
public int maxDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int count = 0;
    while(!queue.isEmpty()) {//fixed queue size, but need resize in the loop, so add a inner for loop
        int size = queue.size();//queue size is fixed in inner loop, so need to check size every loop
        while(size-- > 0) {//loop all in the same level
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        count++;
    }
    return count;
}

