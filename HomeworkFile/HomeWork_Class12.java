
public class HomeWork_Class12 {
//101. 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.offer(root.left);
        nodeList.offer(root.right);
        while(!nodeList.isEmpty()){
            TreeNode left = nodeList.poll();
            TreeNode right = nodeList.poll();
            if(left==null && right==null)
                continue;
            if(left==null||right==null||left.val!=right.val)
                return false;
            nodeList.offer(left.left);
            nodeList.offer(right.right);
            nodeList.offer(left.right);
            nodeList.offer(right.left);

        }
        return true;
    }
//104. 二叉树的最大深度
public int maxDepth(TreeNode root) {
    return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}

//94. 二叉树的中序遍历
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> results = new ArrayList<>();
    Stack<TreeNode> stack = new Stack();
    if(root!=null) stack.push(root);
    else return results;
    while(stack.size()>0){
        while(root!=null){
            if(root.left!=null){
                stack.push(root.left);
            }
            root = root.left;
        }

        root = stack.pop();
        results.add(root.val);
        if(root.right!=null)
            stack.push(root.right);
        root = root.right;
    }
    return results;
}
//106. 从中序与后序遍历序列构造二叉树
HashMap<Integer, Integer> map = new HashMap<>();
    int[] po;
    int[] io;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i =  0; i < inorder.length;i++) map.put(inorder[i],i);
        po = postorder;
        io = inorder;
        return tree(0,inorder.length-1,0,postorder.length-1);
    }
    TreeNode tree(int is,int ie, int ps, int pe){
        if(is>ie || ps > pe) return null;
        TreeNode node = new TreeNode(po[pe]);
        int index  = map.get(node.val);

        node.left = tree(is,index-1,ps,ps+index-1-is);
        node.right = tree(index+1,ie,ps+index-is,pe-1);
        return node;
    }
//102. 二叉树的层序遍历
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> results = new LinkedList<>();
    if(root==null) return results;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        Queue<TreeNode> nextQue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left!=null) nextQue.offer(node.left);
            if(node.right!=null) nextQue.offer(node.right);
        }
        queue = nextQue;
        results.add(result);
    }
    return results;
}
}
