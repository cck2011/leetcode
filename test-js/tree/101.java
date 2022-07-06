//wrong
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
//recursion
public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    // if(p==null && q==null) return true;
    // if(p==null || q==null) return false;
    if(left==null || right==null)//filter except both have value 
        return left==right;
    if(left.val!=right.val)
        return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}

//iteration
public boolean isSymmetric(TreeNode root) {
    if(root==null)  return true;
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode left, right;
    if(root.left!=null){//filter except both are null
        if(root.right==null) return false;
        stack.push(root.left);
        stack.push(root.right);
    }
    else if(root.right!=null){//only right have
        return false;
    }
        
    while(!stack.empty()){
        //if(stack.size()%2!=0)   return false;//still pass when comment
        right = stack.pop();
        left = stack.pop();
        if(right==null && left == null)continue;
        if(right ==null || left == null)return false;
        if(right.val!=left.val) return false;//cannot get value if is null
        //filter except both are null
       // if(left.left!=null){//left have
        //    if(right.right==null)   return false;//right have no
            stack.push(left.left);//both have
            stack.push(right.right);
      //  }
       // else if(right.right!=null){//right have, left have null
       //     return false;
       // }
            
     //   if(left.right!=null){
       //     if(right.left==null)   return false;
            stack.push(left.right);
            stack.push(right.left);
      //  }
        //else if(right.left!=null){
       //     return false;
        }
    
    
    return true;
}

public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.empty()) {
        TreeNode n1 = stack.pop(), n2 = stack.pop();
        if (n1 == null && n2 == null) continue;//skip this loop
        if (n1 == null || n2 == null || n1.val != n2.val) return false;//check null before check value
        stack.push(n1.left);
        stack.push(n2.right);
        stack.push(n1.right);
        stack.push(n2.left);
    }
    return true;
}

//wrong
class Solution {
public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    // if(left==null || right==null)
    //     return left==right;
    // if(left!==null){
    //     if(right ==null)return false;
    //     return true;
    // }
    // elseif(left == null){
    //     if(right ==null)return true;
    //     return false;
    // }
    if(left!=null){
        if(right==null) return false;
        return true;
    }
    else if(right!=null){
        return false;
    }else if(right ==left){
        return true;
    }
    if(left.val!=right.val) return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}
}
left      Right
null      not null
not null  null