import java.util.*;

public class H_20210313 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // lc 101
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);

    }

    private boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    // lc 104
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight)  + 1;
        }

    }

    // lc 94
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }

        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    // lc 106
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length ==0 || postorder.length == 0){
            return null;
        }
        TreeNode tree = new TreeNode(postorder[postorder.length-1]);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == postorder[postorder.length-1]){
                tree.left=buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                tree.right=buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));

            }
        }
        return tree;
    }

    //102
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();

        if (root == null){
            return l;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i<= levelSize; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            l.add(level);
        }

        return l;
    }

}

