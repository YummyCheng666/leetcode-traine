package programmercarl.string;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <p>
 * <p>
 * Related Topics 字符串 👍 422 👎 0
 */

public class POffer05TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new POffer05TiHuanKongGeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
        //内存消耗：39.6 MB, 在所有 Java 提交中击败了25.01%
        public String replaceSpace(String s) {
            //安全判断
            if (s == null || s.length() == 0) {
                return "";
            }
            char[] sChar = s.toCharArray();
            //统计空格数
            int count = 0;
            for (char c : sChar) {
                if (c == ' ') {
                    count++;
                }
            }
            //定义新的数组长度
            char[] array = new char[s.length() + count * 2];
            int sIndex = s.length() - 1;
            int index = array.length - 1;
            while (sIndex >= 0) {
                if (sChar[sIndex] == ' ') {
                    array[index--] = '0';
                    array[index--] = '2';
                    array[index] = '%';

                } else {
                    array[index] = sChar[sIndex];
                }
                sIndex--;
                index--;
            }
            return new String(array);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}