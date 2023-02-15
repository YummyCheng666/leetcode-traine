package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
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
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Related Topics 栈 树 深度优先搜索 二叉树 👍 997 👎 0
 */

public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> results = new ArrayList<>();
            traversal(root, results);
            return results;

        }

        public void traversal(TreeNode treeNode, List<Integer> result) {
            //递归终止条件
            if (treeNode == null) {
                return;
            }
            //前序遍历：中左右
            result.add(treeNode.val);
            traversal(treeNode.left, result);//递归左子树
            traversal(treeNode.right, result);//递归右子树
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}