package programmercarl.linkedList;

/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * <p>
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * <p>
 * Related Topics 递归 链表 👍 2950 👎 0
 */

public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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
        //技巧，添加都节点，并且记住尾结点
        public ListNode reverseList(ListNode head) {
            ListNode dummy = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = dummy;
                dummy = head;
                head = temp;
            }
            return dummy;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}