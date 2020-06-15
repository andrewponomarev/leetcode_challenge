package daily._2020._06._15;

public class SearchInABinarySearchTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && root.val != val) {
                root = val < root.val ? root.left : root.right;
            }
            return root;
        }

        public TreeNode searchBST2(TreeNode root, int val) {
            if (root == null || root.val == val) {
                return root;
            }
            return val < root.val ? searchBST2(root.left, val) : searchBST2(root.right, val);
        }
    }

}
