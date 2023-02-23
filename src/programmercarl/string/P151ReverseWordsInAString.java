package programmercarl.string;

/**
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * <p>
 * There is at least one word in s.
 * <p>
 * <p>
 * <p>
 * Follow-up: If the string data type is mutable in your language, can you solve
 * it in-place with O(1) extra space?
 * <p>
 * Related Topics 双指针 字符串 👍 764 👎 0
 */

public class P151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            char[] array = s.toCharArray();
            //1、处理空格，字符串间隔之间只能有一个空格，开头和结束不能存在空格
            array = removeExtraSpaces(array);
            //2、翻转字符串
            reverseString(array, 0, array.length - 1);
            //3、单独翻转单词
            reverseEachWord(array);
            return new String(array);

        }

        //去除空格
        public char[] removeExtraSpaces(char[] array) {
            //双指针去除空格
            int fast = 0;
            int slow = 0;
            for (; fast < array.length; fast++) {
                if (array[fast] != ' ') {
                    //遇到空格，说明一个单词搞完了，slow 加空格，然后进行下一个循环
                    if (slow != 0) {
                        array[slow++] = ' ';
                    }
                    //一个单词一个单词的移动slow
                    while (fast < array.length && array[fast] != ' ') {
                        array[slow++] = array[fast++];
                    }

                }
            }
            char[] newArray = new char[slow];
            //拷贝字符数组
            System.arraycopy(array, 0, newArray, 0, slow);
            return newArray;
        }

        //翻转字符串
        public void reverseString(char[] array, int left, int right) {
            while (left < right) {
                array[left] ^= array[right];
                array[right] ^= array[left];
                array[left] ^= array[right];
                left++;
                right--;
            }
        }

        //翻转字符串中的单词
        public void reverseEachWord(char[] array) {
            //双指针找每个字符串的开始、结束
            int start = 0;
            int end = 0;
            for (; end <= array.length; end++) {
                if (end == array.length || array[end] == ' ') {//end 遇到空格了，需要翻转
                    //遇到空格，翻转字符串的end 应该为end-1
                    //遇到结尾，翻转字符串的end 为end
                    //为统一处理，让结尾字符串end+1，即循环终止条件为end = array.length
                    reverseString(array, start, end - 1);
                    start = end + 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}