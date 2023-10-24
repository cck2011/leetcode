//time : O(n) number of nodes is n, all nodes need to be travsal
//space : O(logn) not n because same node add together will use the same space
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    if (t1 == null) return t2;
    if (t2 == null) return t1;
    TreeNode root = new TreeNode(t1.val + t2.val);
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);
    return root;
}

public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
  if (t1 == null) {//if t1 = null
    return t2;
  }

  if (t2 != null) {//if t2 is not null
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
  }

  return t1;
}
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;//if both null
    if (t1 == null) return t2;//if one child is null
    if (t2 == null) return t1;
    TreeNode root = new TreeNode(t1.val + t2.val);//if both have children then create a new node
    //no need to inculde root in recursion as it already merge the root
    root.left = mergeTrees(t1.left, t2.left);//go end of t1 and t2, assign to root.left
    root.right = mergeTrees(t1.right, t2.right);//assign to root.right
    return root;


 t1            t2
   2            2
 1   3         2  4
2      
process: 
return root
root.right = mergeTrees(root)
root.left = mergeTrees(root)
root.left = mergeTrees(t1)

TreeNode root = new TreeNode(t1.val + t2.val);

// Method 2: Iterative DFS
// Time: O(n)
// Space: O(height)
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
  if (t1 == null) {
    return t2;
  }
  // Use stack to help DFS
  Deque<TreeNode[]> stack = new LinkedList<>();
  stack.offerLast(new TreeNode[] {t1, t2});
  while (!stack.isEmpty()) {
    TreeNode[] cur = stack.pollLast();
    // no need to merge t2 into t1
    if (cur[1] == null) {
      continue;
    }
    // merge t1 and t2
    cur[0].val += cur[1].val;
    // if node in t1 == null, use node in t2 instead
    // else put both nodes in stack to merge
    // need to handle t1 left may be null and t2 left may be null
    if (cur[0].left == null) {
      cur[0].left = cur[1].left;
    } else {
      stack.offerLast(new TreeNode[] {cur[0].left, cur[1].left});
    }
    if (cur[0].right == null) {
      cur[0].right = cur[1].right;
    } else {
      stack.offerLast(new TreeNode[] {cur[0].right, cur[1].right});
    }
  }
  return t1;
}
// iterative dfs, I use two stack
// Method 3: Iterative BFS
// Time: O(n)
// Space: O(n)
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
  if (t1 == null) {
    return t2;
  }
  // Use stack to help DFS
  Queue<TreeNode[]> queue = new LinkedList<>();
  queue.offer(new TreeNode[] {t1, t2});
  while (!queue.isEmpty()) {
    TreeNode[] cur = queue.poll();
    // no need to merge t2 into t1
    if (cur[1] == null) {
      continue;
    }
    // merge t1 and t2
    cur[0].val += cur[1].val;
    // if node in t1 == null, use node in t2 instead
    // else put both nodes in stack to merge
    if (cur[0].left == null) {
      cur[0].left = cur[1].left;
    } else {
      queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
    }
    if (cur[0].right == null) {
      cur[0].right = cur[1].right;
    } else {
      queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
    }
  }
  return t1;
}

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) 
    {
        Stack <TreeNode> s = new Stack <TreeNode>();
        s.push(t1);
        s.push(t2);
        if (t1 == null)
            return t2;
 
        while(!s.isEmpty())
        {
            TreeNode two = s.pop();
            TreeNode one = s.pop();
            
            if (one != null && two != null)
            {
                one.val += two.val;
                if (one.left == null){//if left is null, if two.left is null, then the remaining tree of one do not need to change.
                    one.left = two.left;
                }
                else
                {
                    s.push(one.left);
                    s.push(two.left);
                }
                      
                if (one.right == null){
                    one.right = two.right;
                }
                else
                {
                    s.push(one.right);
                    s.push(two.right);
                }  
            }     
        }
        return t1;  
    }
}