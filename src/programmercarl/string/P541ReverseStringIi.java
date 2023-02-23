package programmercarl.string;

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k
 * characters counting from the start of the string.
 * <p>
 * If there are fewer than k characters left, reverse all of them. If there are
 * less than 2k but greater than or equal to k characters, then reverse the first k
 * characters and leave the other as original.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * <p>
 * Example 2:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s consists of only lowercase English letters.
 * 1 <= k <= 10⁴
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 419 👎 0
 */

public class P541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:1 ms,击败了61.81% 的Java用户
        //	内存消耗:41.3 MB,击败了70.06% 的Java用户
        public String reverseStr1(String s, int k) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i += 2 * k) {
                //定义翻转数组的start 和end
                int start = i;
                //start+k-1 可能大于数组长度，所以
                int end = (start + k - 1) > chars.length - 1 ? chars.length - 1 : start + k - 1;
                //开始翻转字符串
                while (start < end) {
                    char temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;
                    start++;
                    end--;
                }
            }
            return new String(chars);
        }

        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i += 2 * k) {
                //定义翻转数组的start 和end
                int start = i;
                //start+k-1 可能大于数组长度，所以
                int end = (start + k - 1) > chars.length - 1 ? chars.length - 1 : start + k - 1;
                //开始翻转字符串
                while (start < end) {
                    /*char temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;*/
                    chars[start] ^= chars[end];
                    chars[end] ^= chars[start];
                    chars[start] ^= chars[end];
                    start++;
                    end--;
                }
            }
            return new String(chars);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}