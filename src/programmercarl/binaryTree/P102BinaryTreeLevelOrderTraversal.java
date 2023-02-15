package programmercarl.binaryTree;

import programmercarl.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes'
 * values. (i.e., from left to right, level by level).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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
 * Related Topics 树 广度优先搜索 二叉树 👍 1571 👎 0
 */

public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
        //执行耗时:0 ms,击败了100.00% 的Java用户
        //	内存消耗:41.4 MB,击败了81.14% 的Java用户
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();
            if (root == null) {
                return results;
            }
            //创建队列
            Deque<TreeNode> treeNodeDeque = new LinkedList<>();
            treeNodeDeque.offer(root);//先把根节点放入
            while (!treeNodeDeque.isEmpty()) {
                int size = treeNodeDeque.size();//不是所有数据都放在一个list，一行一list，所以要记录每行个数
                List<Integer> list = new ArrayList<>();//每一行的数据都是一个list
                while (size > 0) {
                    TreeNode node = treeNodeDeque.poll();//把数据弹出
                    list.add(node.val);
                    if (node.left != null) {//弹出的节点，左子节点不为空，将子节点加入
                        treeNodeDeque.offer(node.left);
                    }
                    if (node.right != null) {
                        treeNodeDeque.offer(node.right);
                    }
                    size--;
                }
                results.add(list);
            }
            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}