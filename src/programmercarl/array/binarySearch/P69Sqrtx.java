package programmercarl.array.binarySearch;
//Given a non-negative integer x, return the square root of x rounded down to 
//the nearest integer. The returned integer should be non-negative as well. 
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down 
//to the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1251 👎 0


public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 计算算术平方根

        /**
         * 解题思路：在0-X 中，有一个数n，n*n <= x
         * 注意：1、n 必定存在。n 可为浮点型,所以n取n*n <= x 的最后一个整形
         */
        public int mySqrt(int x) {
            int low = 0;
            int hight = x;
            int answer = 0;
            while (low <= hight) {
                int mid = (hight - low) / 2 + low;
                if ((long) mid * mid > x) {
                    hight = mid - 1;
                } else if ((long) mid * mid <= x) {
                    low = mid + 1;
                    answer = mid;
                }
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}