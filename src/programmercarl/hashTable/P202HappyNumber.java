package programmercarl.hashTable;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * <p>
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops
 * endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * <p>
 * <p>
 * Return true if n is a happy number, and false if not.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1² + 9² = 82
 * 8² + 2² = 68
 * 6² + 8² = 100
 * 1² + 0² + 0² = 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 2
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 哈希表 数学 双指针 👍 1214 👎 0
 */

public class P202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new P202HappyNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:1 ms,击败了82.99% 的Java用户
        //内存消耗:38.5 MB,击败了87.72% 的Java用户
        public boolean isHappy(int n) {
            //用hastset 判断无限循环
            HashSet<Integer> hashSet = new HashSet<>();
            while (n != 1 && !hashSet.contains(n)) {
                n = getNextNumber(n);
            }
            return n == 1;
        }

        public int getNextNumber(int n) {
            int sum = 0;
            while (n > 0) {
                int temp = n % 10;
                sum += temp * temp;
                n = n / 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}