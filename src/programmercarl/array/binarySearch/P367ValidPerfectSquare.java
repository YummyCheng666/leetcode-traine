package programmercarl.array.binarySearch;
//给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。 
//
// 不能使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
//解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
//解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 464 👎 0


public class P367ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new P367ValidPerfectSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路转换：求是否完全平方数，转换为求一个1-n 的升序数组中，target * target =n
         * 大数据相乘，注意边界问题
         * @param num
         * @return
         */
        public boolean isPerfectSquare(int num) {
            int low = 1;
            int hight = num;
            while (low <= hight) {
                int mid = (hight - low) / 2 + low;
                if ((long) mid * mid == num) {// 大数据相乘，注意越界，所以用long
                    return true;
                } else if ((long) mid * mid > num) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}