package leetcode;

import java.util.Stack;

class ValidBST {

    public static boolean isValidBST(TreeNode root) {

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode prev = null;
        if(root == null) return true;

        while (root!=null || !nodes.empty()) {
            while (root!=null) {
                nodes.push(root);
                root = root.left;
            }
            root = nodes.pop();

            if (prev!=null && prev.val>=root.val) return false;

            prev = root;
            root = root.right;

        }
    return false;
    }

    public static void main(String[] args) {

    }
}
