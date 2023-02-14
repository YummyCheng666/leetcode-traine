package programmercarl.hashTable;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * <p>
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * <p>
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * <p>
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 10⁵
 * ransomNote and magazine consist of lowercase English letters.
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 计数 👍 636 👎 0
 */

public class P383RansomNote {
    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:1 ms,击败了99.74% 的Java用户
        //	内存消耗:41.8 MB,击败了50.26% 的Java用户
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] record = new int[26];
            //杂志字数太短，凑不出赎金信
            if (magazine.length() < ransomNote.length()) {
                return false;
            }
            //先从杂志中加字母开始计数
            for (char c : magazine.toCharArray()) {
                record[c - 'a']++;
            }
            //再从赎金信中减去所需字母
            for (char c : ransomNote.toCharArray()) {
                record[c - 'a']--;
            }
            for (int num : record) {
                //字数出现小于0，说明ransomNote字符串总存在magazine中没有的字符
                if (num < 0) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}