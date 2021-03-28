// 235
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while(true){
            if(root.val >= p.val && root.val <= q.val){
                return root;
            }else if(root.val < p.val) root = root.right;
            else root = root.left;
        }
        
    }
}
// 108
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        int index = nums.length/2;
        TreeNode root=new TreeNode(nums[index]);
        root.left=index==0?null:sortedArrayToBST(Arrays.copyOfRange(nums,0,index));
        root.right=index==nums.length-1?null:sortedArrayToBST(Arrays.copyOfRange(nums,index+1,nums.length));
        return root;
    }
}

