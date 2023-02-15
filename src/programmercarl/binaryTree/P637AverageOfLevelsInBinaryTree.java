package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the average value of the nodes on each
 * level in the form of an array. Answers within 10⁻⁵ of the actual answer will be
 * accepted.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 * and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [1, 10⁴].
 * -2³¹ <= Node.val <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 391 👎 0
 */

public class P637AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P637AverageOfLevelsInBinaryTree().new Solution();
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> answer = new ArrayList<>();
            if (root != null) {
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    int size = levelSize;
                    double sum = 0.0;
                    while (size > 0) {//levelSize 不能修改
                        TreeNode node = queue.poll();
                        sum += node.val;
                        if (node.left != null) {
                            queue.offer(node.left);
                        }
                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                        size--;
                    }
                    answer.add(sum / levelSize);
                }
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}