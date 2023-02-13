package programmercarl.linkedList;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at
 * which the two lists intersect. If the two linked lists have no intersection at
 * all, return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the
 * entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the
 * function returns.
 * <p>
 * Custom Judge:
 * <p>
 * The inputs to the judge are given as follows (your program is not given these
 * inputs):
 * <p>
 * <p>
 * intersectVal - The value of the node where the intersection occurs. This is 0
 * if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to
 * get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to
 * get to the intersected node.
 * <p>
 * <p>
 * The judge will then create the linked structure based on these inputs and pass
 * the two heads, headA and headB to your program. If you correctly return the
 * intersected node, then your solution will be accepted.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2,
 * skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if
 * the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,
 * 6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3
 * nodes before the intersected node in B.
 * - Note that the intersected node's value is not 1 because the nodes with value 1
 * in A and B (2ⁿᵈ node in A and 3ʳᵈ node in B) are different node references. In
 * other words, they point to two different locations in memory, while the nodes
 * with value 8 in A and B (3ʳᵈ node in A and 4ᵗʰ node in B) point to the same
 * location in memory.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB
 * = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if
 * the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,
 * 2,4]. There are 3 nodes before the intersected node in A; There are 1 node
 * before the intersected node in B.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it
 * reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
 * while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 10⁴
 * 1 <= Node.val <= 10⁵
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you write a solution that runs in
 * O(m + n) time and use only
 * O(1) memory?
 * <p>
 * Related Topics 哈希表 链表 双指针 👍 1972 👎 0
 */

public class P160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new P160IntersectionOfTwoLinkedLists().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        //先计算长度，再计算差值
        //根据差值，长短链表对齐一起走，找到第一个相等节点
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = nodeLength(headA);
            int lengthB = nodeLength(headB);
            //调整长链表的起始点
            if (lengthA > lengthB) {
                headA = getBeginNode(headA, lengthA - lengthB);
            } else {
                headB = getBeginNode(headB, lengthB - lengthA);
            }
            //开始逐级对比
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
            //对比到最后，都不相等，返回null
            return null;

        }

        private int nodeLength(ListNode listNode) {
            int length = 0;
            while (listNode != null) {
                length++;
                listNode = listNode.next;
            }
            return length;
        }

        private ListNode getBeginNode(ListNode listNode, int k) {
            for (int i = k; i > 0; i--) {
                if (listNode != null) {
                    listNode = listNode.next;
                }
            }
            return listNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}