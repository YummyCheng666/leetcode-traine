package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of
 * it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,null,3]
 * Output: [1,3]
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
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 810 👎 0
 */

public class P199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> results = new ArrayList<>();
            if (root != null) {
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                    int leveSize = queue.size();
                    for (int i = 0; i < leveSize; i++) {
                        TreeNode treeNode = queue.poll();
                        if (i == leveSize - 1) {//只要每层最后一个数据
                            results.add(treeNode.val);
                        }
                        if (treeNode.left != null) {
                            queue.offer(treeNode.left);
                        }
                        if (treeNode.right != null) {
                            queue.offer(treeNode.right);
                        }
                    }
                }
            }

            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}