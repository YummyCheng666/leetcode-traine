package programmercarl.array.slidingWindow;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates) is
 * included in the window. If there is no such substring, return the empty string "".
 * <p>
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10⁵
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 2326 👎 0
 */

public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        String s = "a", t = "aa";
        System.out.print("结果是" + solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:2 ms,击败了99.43% 的Java用户
        //内存消耗:41.3 MB,击败了96.12% 的Java用户
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
                return "";
            }
            int[] need = new int[128];//包括键盘上的所有字符，统计t 所出现的字符数
            for (int i = 0; i < t.length(); i++) {
                need[t.charAt(i)]++;
            }
            int count = t.length();//所需字符长度

            int[] have = new int[128];// 统计s 中t包含的字符所所出现的次数
            //定义滑动窗口左右边界，size
            int left = 0, right = 0, size = Integer.MAX_VALUE;
            int start = 0;

            while (right < s.length()) {//滑动窗口右边界开始滑
                char ch = s.charAt(right);
                // 找到一个t中包含的字符
                if (need[ch] > 0) {
                    have[ch]++;
                    //t 中包含的字母少于需要字母，当前字母有效，所需字母长度减少。
                    if (have[ch] <= need[ch]) {
                        count--;
                    }
                }
                //找到t中包含的所有字符串，右边界暂停滑动，left 开始滑动
                //当前状态have[c]>=need[c]
                //1、have[c] =0 的数据直接释放，left++
                //2、have[c]>=need[c],释放到have[c]<need[c],count++,left 停止滑动
                //3、left 不能大于right
                while (count == 0) {
                    char leftChar = s.charAt(left);
                    //have[c] =0 的数据直接释放，left++
                    if (have[leftChar] > 0) {
                        if (have[leftChar] <= need[leftChar]) {
                            count++;
                        }
                        have[leftChar]--;
                    }
                    if (right - left + 1 < size) {
                        size = right - left + 1;
                        start = left;
                    }
                    left++;
                }
                right++;//滑动窗口右边界继续滑动
            }

            return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}