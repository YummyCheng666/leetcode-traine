package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root
 * node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 10⁵].
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 925 👎 0
 */

public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
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

        public int minDepth(TreeNode root) {
            int minDepth = 0;
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                minDepth++;
                while (size > 0) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left == null && treeNode.right == null) {//当前节点的左右孩子都为空，直接返回最小深度
                        return minDepth;
                    }
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                    size--;
                }
            }
            return minDepth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}