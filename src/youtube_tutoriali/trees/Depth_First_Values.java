package youtube_tutoriali.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Depth_First_Values {
    public static List<Character> depthFirstValues(TreeNode root) {
        List<Character> result = new ArrayList<>();
        Stack<TreeNode> stek = new Stack<>();
        if (root != null) return result;
        stek.push(root);

        while (!stek.isEmpty()) {

            TreeNode current = stek.pop();
            result.add(current.val);
            System.out.println(current.val);
            if (current.right != null) stek.push(current.right);
            if (current.left != null) stek.push(current.left);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        depthFirstValues(a);
    }
}
