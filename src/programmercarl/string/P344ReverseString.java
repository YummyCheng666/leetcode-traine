package programmercarl.string;

/**
 * Write a function that reverses a string. The input string is given as an array
 * of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] is a printable ascii character.
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 725 👎 0
 */

public class P344ReverseString {
    public static void main(String[] args) {
        Solution solution = new P344ReverseString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            if (s.length <= 0) {
                return;
            }
            for (int start = 0, end = s.length - 1; start < end; start++, end--) {
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}