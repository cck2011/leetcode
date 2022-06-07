public class Solution{
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        max = Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
//dfs stack first in last out
//peek read the first element in stack
public class Solution{
    //
    public int diameterOfBinaryTree(TreeNode root) {
    Stack<TreeNode> stack = new LinkedList<>();
    Stack<TreeNode> max = new LinkedList<>();

    stack.push(root);
    max.push(0);

    while(!stack.isEmpty()){
        node = stack.pop();
        value = max.pop();
        if(node.left != null){
            stack.push(node.left);
            max.push(value+1)
        }
        if(node.right != null){
            stack.push(node.right);
            max.push(value+1)
        }
    }
    int max = max.pop()
    return max;
    }
}
//getOrDefault() 方法獲取指定key 對應對value，如果找不到key ，則返回設置的默認值。
public class Solution{
public int diameterOfBinaryTree(TreeNode root) {
        if( root == null){
            return 0;
        }

        int overallNodeMax = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Map<TreeNode,Integer> CountMap = new HashMap<>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.peek();
            if(node.left != null && !CountMap.containsKey(node.left)){// if have left and not in hashmap
                nodeStack.push(node.left);
            }else if(node.right!=null && !CountMap.containsKey(node.right)){
                nodeStack.push(node.right);
                
            }else {// if all children already record in hashmap which only have null left,
            // then go upper layer and update the overallNodeMax and itself nodelegth 
                TreeNode topNode = nodeStack.pop();
                int leftMax = CountMap.getOrDefault(node.left,0);
                int rightMax = CountMap.getOrDefault(node.right,0);
                overallNodeMax = Math.max(overallNodeMax,leftMax + rightMax );
                int nodelength = 1 + Math.max(leftMax,rightMax);
                CountMap.put(node,nodelength);
                
            }
            
        }
        return overallNodeMax;
        
    } 
}