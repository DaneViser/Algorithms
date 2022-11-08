package youtube_tutoriali.trees;

import java.util.List;

public class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(char val) {
        this.val = val;
    }

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
