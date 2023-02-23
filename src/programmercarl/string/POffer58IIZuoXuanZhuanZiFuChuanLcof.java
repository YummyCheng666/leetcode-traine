package programmercarl.string;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <p>
 * <p>
 * Related Topics 数学 双指针 字符串 👍 356 👎 0
 */

public class POffer58IIZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new POffer58IIZuoXuanZhuanZiFuChuanLcof().new Solution();
        String s = "lrloseumgh";
        int k = 6;
        System.out.println(solution.reverseLeftWords(s, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行用时：1 ms, 在所有 Java 提交中击败了59.51%的用户
        //内存消耗：41.4 MB, 在所有 Java 提交中击败了52.10%的用户
        public String reverseLeftWords1(String s, int n) {
            if (s == null || s.length() <= 0) {
                return s;
            }
            char[] chars = s.toCharArray();
            char[] newArray = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                int index = (i + (chars.length - n)) % chars.length;
                newArray[index] = chars[i];
            }
            return new String(newArray);
        }

        //执行用时：2 ms, 在所有 Java 提交中击败了49.80%的用户
        // 内存消耗：41.4 MB, 在所有 Java 提交中击败了53.89%的用户
        public String reverseLeftWords(String s, int n) {
            if (s == null || s.length() <= 0 || n == 0) {
                return s;
            }
            char[] array = s.toCharArray();
            //先翻转0到n-1
            reverse(array, 0, n - 1);
            //在翻转n到lenght-1
            reverse(array, n, array.length - 1);
            //翻转整个字符串0到lenght-1
            reverse(array, 0, array.length - 1);
            return new String(array);
        }

        public void reverse(char[] array, int left, int right) {
            while (left < right) {
                array[left] ^= array[right];
                array[right] ^= array[left];
                array[left] ^= array[right];
                left++;
                right--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}