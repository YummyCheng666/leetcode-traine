package programmercarl.hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length, p.length <= 3 * 10⁴
 * s and p consist of lowercase English letters.
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 1089 👎 0
 */

public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        String s = "abab", p = "ab";
        solution.findAnagrams(s,p);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:5 ms,击败了96.17% 的Java用户
        //内存消耗:42.6 MB,击败了44.30% 的Java用户
        public List<Integer> findAnagrams(String s, String p) {
            //安全判断
            if (s.length() < p.length()) {
                return new ArrayList<>();
            }
            List<Integer> findAnagrams = new ArrayList<>();
            //先统计p 上需要的字符
            char[] pArray = p.toCharArray();
            int[] pCount = new int[26];
            for (char c : pArray) {
                pCount[c - 'a']++;
            }
            //滑动窗口
            //异位词满足条件：
            // 1、right-left+1=p.lenght
            // 2、pcount[c] =scount[c]
            int left = 0, right = 0;
            int[] sCount = new int[26];
            char[] sArray = s.toCharArray();
            int count = 0;//记录是否满足异位词长度
            while (right < sArray.length) {
                //找到异位词中需要的字符了
                if (pCount[sArray[right]-'a'] > 0) {
                    if (pCount[sArray[right]-'a'] > sCount[sArray[right]-'a']) {
                        //找到满足的异位词了
                        count++;
                    }
                    sCount[sArray[right]-'a']++;
                }
                //left 开始调整条件，长度==p.length
                if ((right - left) + 1 == pArray.length) {
                    //判断异位词是否满足
                    if (count == pArray.length) {
                        findAnagrams.add(left);
                    }
                    if (pCount[sArray[left]-'a'] > 0) {
                        if (pCount[sArray[left]-'a'] >= sCount[sArray[left]-'a']) {
                            //找到满足的异位词了
                            count--;
                        }
                        sCount[sArray[left]-'a']--;
                    }
                    left++;
                }

                right++;
            }
            return findAnagrams;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}