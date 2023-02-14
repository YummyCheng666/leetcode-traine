package programmercarl.hashTable;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length, t.length <= 5 * 10⁴
 * s and t consist of lowercase English letters.
 * <p>
 * <p>
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 * <p>
 * Related Topics 哈希表 字符串 排序 👍 727 👎 0
 */

public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Hash 有3中方式，数组，map set
        //执行耗时:4 ms,击败了36.89% 的Java用户
        //内存消耗:41.5 MB,击败了60.74% 的Java用户
        public boolean isAnagramSlow(String s, String t) {
            int[] record = new int[26];
            if (s.length() != t.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                record[s.charAt(i) - 'a']++;
                record[t.charAt(i) - 'a']--;
            }
            for (int num : record) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }

        //优化，s.charAt 直接转数组
        //执行耗时:2 ms,击败了87.96% 的Java用户
        //内存消耗:41.4 MB,击败了75.07% 的Java用户
        public boolean isAnagramFast(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] record = new int[26];
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            for (int i = 0; i < sArray.length; i++) {
                record[sArray[i] - 'a']++;
                record[tArray[i] - 'a']--;
            }
            for (int num : record) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }

        //第三次优化，老实写三个for 循环
        //执行耗时:1 ms,击败了100.00% 的Java用户
        //内存消耗:41.5 MB,击败了66.71% 的Java用户
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] record = new int[26];
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            for (int i = 0; i < sArray.length; i++) {
                record[sArray[i] - 'a']++;
            }
            for (int i = 0; i < tArray.length; i++) {
                record[tArray[i] - 'a']--;
            }
            for (int num : record) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}