package programmercarl.linkedList;

/**
 * Design your implementation of the linked list. You can choose to use a singly
 * or doubly linked list. A node in a singly linked list should have two attributes:
 * val and next. val is the value of the current node, and next is a pointer/
 * reference to the next node. If you want to use the doubly linked list, you will need
 * one more attribute prev to indicate the previous node in the linked list. Assume
 * all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexᵗʰ node in the linked list. If
 * the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of
 * the linked list. After the insertion, the new node will be the first node of the
 * linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the
 * linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexᵗʰ
 * node in the linked list. If index equals the length of the linked list, the
 * node will be appended to the end of the linked list. If index is greater than the
 * length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexᵗʰ node in the linked list, if
 * the index is valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex",
 * "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * <p>
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and
 * deleteAtIndex.
 * <p>
 * <p>
 * Related Topics 设计 链表 👍 745 👎 0
 */

public class P707DesignLinkedListII {
    public static void main(String[] args) {
       MyLinkedList solution =  new P707DesignLinkedListII().new MyLinkedList();
        String[] sub = new String[]{"addAtHead", "get", "addAtHead", "addAtHead", "deleteAtIndex", "addAtHead", "get", "get", "get", "addAtHead", "deleteAtIndex"};
        int[][] num = new int[][]{{4}, {1}, {1}, {5}, {3}, {7}, {3}, {3}, {3}, {1}, {4}};
        for (int i = 0; i < sub.length; i++) {
            int[] ints = num[i];
            if (sub[i] == "addAtHead") {
                solution.addAtHead(ints[0]);
                System.out.println("在头部插入插入" + ints[0]);
            } else if (sub[i] == "addAtTail") {
                solution.addAtTail(ints[0]);
                System.out.println("在尾部部插入插入" + ints[0]);
            } else if (sub[i] == "addAtIndex") {
                solution.addAtIndex(ints[0], ints[1]);
                System.out.println("在index 为" + ints[0] + "的地方插入" + ints[1]);
            } else if (sub[i] == "deleteAtIndex") {
                solution.deleteAtIndex(ints[0]);
                System.out.println("删除index 为" + ints[0] + "的值");
            } else if (sub[i] == "get") {
                int val = solution.get(ints[0]);
                System.out.println("获取index 为" + ints[0] + "的值" + val);
            }
            print(solution.head);
            System.out.println("链表长度为：" + solution.size);
        }
    }

    private static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            System.out.print(curr.val + " ");
        }
        System.out.println("");
        System.out.println("===========");
    }




    //leetcode submit region begin(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }

    class MyLinkedList {
        int size;
        ListNode head;
        ListNode tail;

        public MyLinkedList() {
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode curr = null;
            if (index > size / 2) {//index 居于链表后半段，从尾部开始遍历快
                curr = tail;
                for (int i = 0; i < size - index; i++) {
                    curr = curr.prev;
                }
            } else {
                curr = head;
                for (int i = 0; i <= index; i++) {
                    curr = curr.next;
                }
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            //index大于链表长度
            if (index > size) {
                return;
            }
            //index小于0
            if (index < 0) {
                index = 0;
            }
            size++;
            ListNode curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = curr.next;
            curr.next.prev = toAdd;
            curr.next = toAdd;
            toAdd.prev = curr;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.next.next.prev = curr;
            curr.next = curr.next.next;

        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}