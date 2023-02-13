package programmercarl.linkedList;

/**
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos is
 * used to denote the index of the node that tail's next pointer is connected to (0-
 * indexed). It is -1 if there is no cycle. Note that pos is not passed as a
 * parameter.
 * <p>
 * Do not modify the linked list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of the nodes in the list is in the range [0, 10⁴].
 * -10⁵ <= Node.val <= 10⁵
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * <p>
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 * Related Topics 哈希表 链表 双指针 👍 1941 👎 0
 */

public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
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
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // 先快慢指针判断链表是否有环
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;//快指针一下走2步
                slow = slow.next;// 慢指针一下走一步
                if (fast == slow) {//2指针相遇，有环
                    //开始重新循环
                    slow = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}