//cannot use sum of node.val for recursion return ans
//minus
public Solution{
    public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null && root.val == sum) return true;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}
}

//add
class Solution {
    public boolean rootToLeafPathSum(TreeNode root, int targetSum, int sum){
        if(root == null)
            return false;
        if(root.left == null && root.right == null){
            sum = sum + root.val;
            if(sum == targetSum)
                return true;   
        }
        return rootToLeafPathSum(root.left, targetSum, sum + root.val) || rootToLeafPathSum(root.right, targetSum, sum + root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return rootToLeafPathSum(root, targetSum, sum);
    }
}
//same
class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return recursion(root, targetSum ,sum);
        
    }
    public boolean recursion(TreeNode root, int targetSum, int sum) {
        if(root == null)return false;
        boolean l = recursion(root.left,targetSum,sum+root.val);
        boolean r = recursion(root.right,targetSum,sum+root.val);

        if(root.left == null && root.right == null){
            sum = sum + root.val;
            if(sum == targetSum)
                return true;   
        }
        return l||r;
    }
}
eg.
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

if add , 5+4+11=20+2=22 ==22
if minus 22-5-4-11= 2 == 2



class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Stack<TreeNode> s = new Stack<>();

        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            
            if(node.left == null && node.right == null && node.val == targetSum)return true;
            if(node.left != null){
                node.left.val += node.val;
                s.push(node.left);
            }
            if(node.right != null){
                node.right.val += node.val;
                s.push(node.right);
            }
        }
        return false;
    }
}

public Solution{
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null) return false;
        Deque<TreeNode> stack = new LinkedList<>();
        
        stack.offer(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.left == null && cur.right == null){	    		
	    		if (cur.val == sum ) return true ;
	    	}
	    	if (cur.right != null) {
	    		cur.right.val = cur.val + cur.right.val ;
	    		stack.push(cur.right) ;
	    	}
	    	if (cur.left != null) {
	    		cur.left.val = cur.val + cur.left.val;
	    		stack.push(cur.left);
	    	}
            


        }

    }
}

//two other recursive solution
// https://leetcode.com/problems/path-sum/solutions/1329291/java-three-easy-approach-with-explanation-preorder-postorder-0ms/

// iterative solution
// https://leetcode.com/problems/path-sum/solutions/2291836/three-solution-to-come-up-on-iterview-easy-to-understand/
//dfs
public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        stack.push(root);
        sum.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currSum = sum.pop();
            if (currSum == targetSum && node.left == null && node.right == null)
                return true;
            
            if (node.right != null) {
                stack.push(node.right);
                sum.push(node.right.val + currSum);
            }
            if (node.left != null) {
                stack.push(node.left);
                sum.push(node.left.val + currSum);
            }
        }
        return false;
    }
//bfs
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();
        queue.add(root);
        sum.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                int currSum = sum.remove();
                if (currSum == targetSum && node.left == null && node.right == null) {
                    return true;
                }
                
                
               if (node.left != null) {
                    queue.add(node.left);
                    sum.add(node.left.val + currSum);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    sum.add(node.right.val + currSum);
                }
            }
        }
        return false;
    }