import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class H_20210321 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // lc 235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true){
            if (p.val < ancestor.val && q.val < ancestor.val){
                ancestor = ancestor.left;
            }else if (p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }else{
                break;
            }
        }

        return ancestor;
    }

    // lc 108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return treeNodeBuild(nums, 0, nums.length - 1);
    }

    public TreeNode treeNodeBuild(int[] nums, int left, int right){
        if (left > right){
            return null;
        }

        int mid = (left +  right )/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = treeNodeBuild(nums, left, mid-1);
        root.right = treeNodeBuild(nums, mid + 1, right);
        return root;
    }

    // lc 449. 序列化和反序列化二叉搜索树
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null){
                return "!";
            }

            Queue<TreeNode> queue = new LinkedList<>();
            StringBuffer sb = new StringBuffer();
            queue.add(root);

            while (!queue.isEmpty()){

                TreeNode node = queue.poll();

                if (node == null){
                    sb.append("!,");
                    continue;
                }

                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);

            }

            return sb.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "!"){
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            String[] values = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            queue.add(root);

            for (int i = 1; i < values.length; i++){
                TreeNode parent = queue.poll();
                if (!values[i].equals("!")){
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    queue.add(left);
                }

                if (!values[++i].equals("!")){
                    TreeNode right = new TreeNode(Integer.parseInt(values[++i]));
                    parent.right = right;
                    queue.add(right);
                }
            }


            return root;


        }
    }


    // lc 1775. 通过最少操作次数使数组的和相等
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i<nums1.length;i++){
            sum1 += nums1[i];
        }

        for (int j = 0; j < nums2.length; j++){
            sum2 += nums2[j];
        }

        if (sum1 == sum2){
            return 0;
        }else if(sum1 > sum2){
            return minOperations(nums2, nums1);
        }

        // 默认sum1s 小于 sums2
        int diff = sum2 - sum1;

        int result = 0;

        int num[] =  new int[6];

        for (int i = 0; i< nums1.length; i++){
            num[6-nums1[i]]++;
        }

        for (int j = 0; j < nums2.length; j++){
            num[nums2[j] - 1]++;
        }

        for (int i = 5; i >= 1&& diff > 0; i--){
            while (num[i] > 0 && diff > 0){
                diff -= i;
                num[i]--;
                result ++;
            }
        }

        return diff > 0 ? -1: result;



    }

    // lc 1706. 球会落何处
    public int[] findBall(int[][] grid) {

    }
}
