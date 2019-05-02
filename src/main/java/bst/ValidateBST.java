package bst;

import java.util.Stack;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode prev = null;
        if (root == null) return true;

        while (root != null || !nodes.empty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            root = nodes.pop();

            if (prev != null && prev.val >= root.val) return false;

            prev = root;
            root = root.right;

        }
        return false;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(9);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.right = node4;
        node1.left = node3;

    }
}
