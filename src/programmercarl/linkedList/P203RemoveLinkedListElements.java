package programmercarl.linkedList;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the
 * linked list that has Node.val == val, and return the new head.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [], val = 1
 * Output: []
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the list is in the range [0, 10⁴].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * <p>
 * <p>
 * Related Topics 递归 链表 👍 1158 👎 0
 */

public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //执行耗时:0 ms,击败了100.00% 的Java用户
        //	内存消耗:42.4 MB,击败了39.00% 的Java用户
        public ListNode removeElements(ListNode head, int val) {
            // 给head 加一个新头，遇到相等，把自己替换成下一个元素
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            ListNode preNode = dummyNode;
            while (preNode.next != null) {
                if (preNode.next.val == val) {
                    preNode.next = preNode.next.next;
                } else {
                    preNode = preNode.next;
                }
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}