//recursion DFS O(N)
class solution {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);//l and r = length of current node
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) return result = false;//math.abs must return postitive number
        return 1 + Math.max(l, r);//from buttom to top and run the previous line code in each node it travsal,
        //which is to check the child length and reduce it to check balance
    }
}

// same as the above one
class solution {
public:
int dfsHeight (TreeNode *root) {
        if (root == NULL) return 0;
        
        int leftHeight = dfsHeight (root -> left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root -> right);
        if (rightHeight == -1) return -1;
        
        if (abs(leftHeight - rightHeight) > 1)  return -1;
        return max (leftHeight, rightHeight) + 1;
    }
    bool isBalanced(TreeNode *root) {
        return dfsHeight (root) != -1;
    }
};
//DFS O(N^2)
class solution {
public:
    int depth (TreeNode *root) {
        if (root == NULL) return 0;
        return max (depth(root -> left), depth (root -> right)) + 1;
    }

    bool isBalanced (TreeNode *root) {
        if (root == NULL) return true;
        
        int left=depth(root->left);
        int right=depth(root->right);
        
        return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }//this is the same,first run isBalanced recursion then check it's child 
};
//iterative I think this is n logn n time complexity and space?
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if((node.left==null ||
                node.left!=null &&
                map.containsKey(node.left))
             &&
             (node.right==null ||
              node.right!=null && 
              map.containsKey(node.right)))
                //1.come in if both child are null 
                //2.both child are already traversaled
                //3.one child is null and another is already traversaled
              {
                int left = node.left==null?0:map.get(node.left);
                int right = node.right==null?0:map.get(node.right);
                if(Math.abs(left-right) > 1) return false;
                map.put(node, Math.max(left, right)+1);//record
            }else{//if not yet record
                if(node.left!=null && !map.containsKey(node.left)){
                    stack.push(node);//for going back one level upper layer
                    stack.push(node.left);
                }else{//right
                    stack.push(node);
                    stack.push(node.right);
                }
            }
        }
        return true;
    }
}
public class Solution {
    public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }
    
    return getHeight(root) != -1;

    };
    public int getHeight(TreeNode node) {
    if (node == null) {
        return 0;
    }

    int left = getHeight(node.left);
    int right = getHeight(node.right);

    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
        return -1;
    }

    return Math.max(left, right) + 1;

    };
    
};
// i rewrite it after watching question 543
public class Solution{
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Map<TreeNode,Integer> record = new HashMap<TreeNode, Integer>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            
            TreeNode node = nodeStack.peek();
            if(node.left != null && !record.containsKey(node.left)){
                nodeStack.push(node.left);
            }
            else if(node.right != null && !record.containsKey(node.right)){
                nodeStack.push(node.right);
            }else{
                TreeNode topNode = nodeStack.pop();
                int left = record.getOrDefault(root.left,0);
                int right = record.getOrDefault(root.right,0);
                //if is buttom then 0, if not then should have node.left record
                if(Math.abs(left-right) > 1) return false;
                record.put(node,Math.max(left, right)+1);
            }
        }
        return true;

    }
}