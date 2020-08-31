package main.java.daily._2020._08.week_5;

import com.sun.source.tree.Tree;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode t = root;
            root = min(root.right);
            root.right = deleteMin(root.right);
            root.left = t.left;
        }
        return root;
    }

    public TreeNode min(TreeNode root) {
        if (root.left == null) return root;
        return min(root.left);
    }

    public TreeNode deleteMin(TreeNode x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }
}

class TreeNode {
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
