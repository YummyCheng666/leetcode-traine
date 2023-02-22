package programmercarl.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 * <p>
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * <p>
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers, with '#
 * ' signifying the end of each level.
 * <p>
 * <p>
 * Example 2:
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
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * Follow-up:
 * <p>
 * <p>
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not
 * count as extra space for this problem.
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 682 👎 0
 */

public class P117PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new P117PopulatingNextRightPointersInEachNodeIi().new Solution();
        int[] array = new int[]{1,2,3,4,5,0,7};
        Node node = createBinaryTreeByArray(array,0);
        solution.connect(node);
    }

    public static Node createBinaryTreeByArray(int[] array, int index) {
        Node tree = null;
        if (index < array.length) {
            int val = array[index];
            tree = new Node(val);
            tree.left = createBinaryTreeByArray(array, index * 2 + 1);
            tree.right = createBinaryTreeByArray(array, index * 2 + 2);
            return tree;
        }
        return tree;
    }


  static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
;
*/

    class Solution {
        public Node connect(Node root) {
            if (root != null) {
                Queue<Node> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    Node currNode = queue.poll();
                    if (currNode.left != null) {
                        queue.offer(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.offer(currNode.right);
                    }
                    for (int i = 1; i < size; i++) {
                        Node nextNode = queue.poll();
                        if (nextNode.left != null) {
                            queue.offer(nextNode.left);
                        }
                        if (nextNode.right != null) {
                            queue.offer(nextNode.right);
                        }
                        currNode.next = nextNode;
                        currNode = currNode.next;
                    }
                    currNode.next = null;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}