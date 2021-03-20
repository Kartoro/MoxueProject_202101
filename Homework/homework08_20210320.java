// 101
class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode p=root;TreeNode q=root;
          if(p==null) return true;
          else{
      		if(isSameTree(p.left,q.right)&&isSameTree(p.right,q.left))
      			return true;
      		else
      			return false;
      	}
    }
    boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null&&q==null) return true;
    	if(p!=null&&q!=null) {
    		if(p.val==q.val&&isSameTree(p.left,q.right)&&isSameTree(p.right,q.left))
    			return true;
    		else
    			return false;
    	}
    	return false;
    }
}

// 104
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        int lefthigh = maxDepth(root.left);
        int righthigh = maxDepth(root.right);
        int max = Math.max(lefthigh,righthigh);
        return max+1;
    }
}

// 94
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer>ans = new ArrayList<>();
		// dfs
		Deque<TreeNode>stack = new LinkedList<>();
		while(root!=null||!stack.isEmpty()){
			// 循环中push进root，减少判断
			// 走到底
			while (root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			ans.add(root.val);
			// 向右找就OK了
			root = root.right;
		}
		return ans;
    }
}

// 106




// 102

