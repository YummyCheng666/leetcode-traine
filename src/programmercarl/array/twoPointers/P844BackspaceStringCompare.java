package programmercarl.array.twoPointers;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * <p>
 * Related Topics 栈 双指针 字符串 模拟 👍 571 👎 0
 */

public class P844BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new P844BackspaceStringCompare().new Solution();
        System.out.println(solution.backspaceCompare("xywrrmp","xywrrmu#p"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 用双指针解题

        /**
         * 从尾部依次对比每一个不能被#抵消的数据是否相等
         * 1、需记录# 抵消了多少个数据
         * 2、每找到一个不能被# 抵消的数据，需要跟另一个数组当前不能抵消的数据对比
         */
        public boolean backspaceCompare(String s, String t) {
            int sIndex = s.length() - 1;
            int tIndex = t.length() - 1;// 定义指针指向数组尾部

            int skipS = 0;
            int skipT = 0;//记录遇到# 的个数

            while (sIndex >= 0 || tIndex >= 0) { //根据整个数组进行变量
                //s 字符串先找到一个非# 的，并且不被抵消的数据
                while (sIndex >= 0) {
                    if (s.charAt(sIndex) == '#') {//找到#，记录下个数
                        skipS++;
                        sIndex--;//继续往前找
                    } else if (skipS > 0) {//找到非 # 字母，但是skipS 不为0，该字母需抵消
                        skipS--;
                        sIndex--;//继续往前找
                    } else {
                        break;//找到非# 并且不要要抵消的字符
                    }
                }

                // t 字符串先找到一个非# 的，并且不被抵消的数据
                while (tIndex >= 0) {
                    if (t.charAt(tIndex) == '#') {//找到#，记录下个数
                        skipT++;
                        tIndex--;//继续往前找
                    } else if (skipT > 0) {//找到非 # 字母，但是skipS 不为0，该字母需抵消
                        skipT--;
                        tIndex--;//继续往前找
                    } else {
                        break;//找到非# 并且不要要抵消的字符
                    }
                }

                //对比2个找到的字符,如果不相等，返回false，
                if (sIndex >= 0 && tIndex >= 0) {
                    if (s.charAt(sIndex) != t.charAt(tIndex)) {
                        return false;
                    }
                } else {
                    // 至少有一个出界，包含 1. 都出界（不做处理） 2. 当且仅当一个出界（返回false的第二个条件）
                    //1、sIndex < 0 && tIndex < 0 都出界，没找到能对比的字符，return true
                    //2、sIndex < 0 && tIndex > 0 s字符串出界，t没有，返回 false
                    // 3、sIndex >=0  && tIndex < 0 t出界，s没有，返回false
                    if (sIndex >= 0 || tIndex >= 0) {
                        return false;
                    }
                }

                //字符相等，继续前一个字符对比
                sIndex--;
                tIndex--;

            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}