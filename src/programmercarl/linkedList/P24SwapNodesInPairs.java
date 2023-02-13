package programmercarl.linkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes (i.e., only
 * nodes themselves may be changed.)
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1]
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 递归 链表 👍 1707 👎 0
 */

public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                ListNode temp = curr.next.next;
                curr.next.next = curr;
                pre.next = curr.next;
                curr.next = temp;
                pre = curr;
                curr = temp;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}