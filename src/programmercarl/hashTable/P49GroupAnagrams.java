package programmercarl.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return the
 * answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= strs.length <= 10⁴
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 排序 👍 1378 👎 0
 */

public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        //String []strings = new String[]{"ddddddddddg","dgggggggggg"};
        String []strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        solution.groupAnagrams(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> hashMap = new HashMap<>();
            for (String str:strs) {
                String mapKey = getMapKey(str);
                //先根据key 从map 里面获取数据
                List<String> list = hashMap.getOrDefault(mapKey,new ArrayList<>());
                //获取到的list 追加值
                list.add(str);
                //数据放回map
                hashMap.put(mapKey,list);
            }
            return new ArrayList<List<String>>(hashMap.values());
        }

        //执行耗时:10 ms,击败了26.86% 的Java用户
        //	内存消耗:44.6 MB,击败了43.97% 的Java用户
        public String getMapKey1(String str) {
            int[] count = new int[26];
            char[] strChar = str.toCharArray();
            //对字符串进行计数
            for (char c : strChar) {
                count[c - 'a']++;
            }
            //字符串数量+字母返回为map key
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0;i<count.length;i++){
                if (count[i]!=0){
                    stringBuffer.append(count[i]);
                    stringBuffer.append((char)(i+'a'));
                }
            }
            return stringBuffer.toString();
        }
        //执行耗时:4 ms,击败了99.85% 的Java用户
        public String getMapKey(String str) {
            char[] count = new char[26];
            char[] strChar = str.toCharArray();
            //对字符串进行计数
            for (char c : strChar) {
                count[c - 'a']++;
            }
            //字符串数量作为map key
            return String.valueOf(count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}