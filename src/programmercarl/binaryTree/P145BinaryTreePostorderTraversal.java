package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = [1]
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Related Topics 栈 树 深度优先搜索 二叉树 👍 982 👎 0
 */

public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> results = new ArrayList<>();
            traversal(root, results);
            return results;
        }

        public void traversal(TreeNode treeNode, List<Integer> results) {
            if (treeNode == null) {
                return;
            }
            //后续遍历：左右中
            traversal(treeNode.left, results);
            traversal(treeNode.right, results);
            results.add(treeNode.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}