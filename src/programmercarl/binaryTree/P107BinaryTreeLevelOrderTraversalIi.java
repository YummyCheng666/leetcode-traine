package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal of
 * its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics 树 广度优先搜索 二叉树 👍 655 👎 0
 */

public class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();
            if (root == null) {
                return results;
            }
            //定义队列
            Queue<TreeNode> queue = new LinkedList<>();
            //将根节点放入队列
            queue.offer(root);
            //循环队列终止条件，队列为空
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();//队列元素弹出
                    level.add(node.val);
                    //左子节点加入队列
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    //右子节点加入队列
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                results.add(level);
            }
            //从叶子节点遍历二叉树，需翻转list
            List<List<Integer>> answerList = new ArrayList<>();
            for (int i = results.size() - 1; i >= 0; i--) {
                answerList.add(results.get(i));
            }
            return answerList;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}