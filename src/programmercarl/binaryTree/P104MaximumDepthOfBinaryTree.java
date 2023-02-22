package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 10⁴].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1501 👎 0
 */

public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //最大深度，即二叉树层数
        public int maxDepth(TreeNode root) {
            int maxDepth = 0;
            if (root != null) {
                Queue<TreeNode> nodes = new LinkedList<>();
                nodes.offer(root);
                while (!nodes.isEmpty()) {
                    int size = nodes.size();//当前层节点个数
                    while (size > 0) {
                        TreeNode treeNode = nodes.poll();
                        if (treeNode.left != null) {
                            nodes.offer(treeNode.left);
                        }
                        if (treeNode.right != null) {
                            nodes.offer(treeNode.right);
                        }
                        size--;
                    }
                    maxDepth++;
                }
            }
            return maxDepth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}