package programmercarl.binaryTree;

import programmercarl.utils.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,1
 * 2,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10⁴]
 * <p>
 * <p>
 * Related Topics 树 广度优先搜索 👍 338 👎 0
 */

public class P429NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P429NAryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> levelOrder = new ArrayList<>();
            if (root != null) {
                Queue<Node> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    List<Integer> level = new ArrayList<>();
                    while (levelSize > 0) {
                        Node node = queue.poll();
                        level.add(node.val);
                        if (!node.children.isEmpty()) {
                            for (Node child : node.children) {
                                queue.offer(child);
                            }
                        }
                        levelSize--;
                    }
                    levelOrder.add(level);
                }
            }
            return levelOrder;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}