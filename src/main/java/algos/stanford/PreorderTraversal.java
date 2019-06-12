package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {


    }

    private static ArrayList<Integer> preorderTraversal (TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();

        nodes.push(root);

        while (!nodes.empty()) {
            //check - peek or pop?
            TreeNode curr = nodes.peek();

            if (curr!=null) {
                nodes.push(root.left);
                nodes.push(root.right);
            }

            result.add(root.val);
        }

        return result;
    }

}
