package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return an array of the largest value in each
 * row of the tree (0-indexed).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: [1,3]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree will be in the range [0, 10⁴].
 * -2³¹ <= Node.val <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 298 👎 0
 */

public class P515FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> largestValues = new ArrayList<>();
            if (root != null) {
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    int levelMaxVale = Integer.MIN_VALUE;
                    while (levelSize > 0) {
                        TreeNode treeNode = queue.poll();
                         levelMaxVale = Math.max(levelMaxVale,treeNode.val);
                       // levelMaxVale = levelMaxVale > treeNode.val ? levelMaxVale : treeNode.val;
                        if (treeNode.left != null) {
                            queue.offer(treeNode.left);
                        }
                        if (treeNode.right != null) {
                            queue.offer(treeNode.right);
                        }
                        levelSize--;
                    }
                    largestValues.add(levelMaxVale);
                }
            }
            return largestValues;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}