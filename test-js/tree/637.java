   //BFS
     public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            list.add(sum / count);
        }
        return list;
    } 
  //DFS
  class Node {
        double sum;
        int count;
        Node (double d, int c) {
            sum = d;
            count = c;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Node> temp = new ArrayList<>();
        helper(root, temp, 0);
        List<Double> result = new LinkedList<>();
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i).sum / temp.get(i).count);
        }
        return result;
    }
    public void helper(TreeNode root, List<Node> temp, int level) {
        if (root == null) return;
        if (level == temp.size()) {// one level one node, level 0 temp size 0 so temp size 1, level 1 temp size 1 so temp size 2. Therefore, temp size is always one step ahead to wait level to wait level.
            Node node = new Node((double)root.val, 1);//add one node to list
            temp.add(node);
        } else {//in same level
            temp.get(level).sum += root.val;// add sum and count
            temp.get(level).count++;
        }
        helper(root.left, temp, level + 1);
        helper(root.right, temp, level + 1);
    }//wt level is in the correct level