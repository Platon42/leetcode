package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class InOrder {

    private static List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();

        if (root == null) return inorder;
        int cnt = -1;
        while (root != null || !nodes.empty()) {

            while (root != null) {
                cnt++;
                nodes.push(root);
                root = root.left;
                //System.out.println(cnt);

                //System.out.println("stack = "+nodes.get(cnt).val);
            }
            //System.out.println("after");

            //retrieve top node and store its right child if exists
            //nodes of right ordering
            //root = nodes.peek();
            root = nodes.pop();

            inorder.add(root.val);
            root = root.right;
        }

        return inorder;
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

        List<Integer> list = inorderTraversal(root);
        for (Integer integer : list){
            System.out.println(integer);

        }
    }
}

