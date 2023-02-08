package programmercarl.array.twoPointers;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of
 * the squares of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums is sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an
 * O(n) solution using a different approach?
 * <p>
 * Related Topics 数组 双指针 排序 👍 714 👎 0
 */

public class P977SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] squares = new int[nums.length];
            int low = 0;
            int hight = nums.length - 1; //定义对撞双指针
            for (int i = squares.length - 1; i >= 0; i--) {//需返回的数组从最后开始装载数据
                int lowSquare = nums[low] * nums[low];
                int hightSquare = nums[hight] * nums[hight];

                if (lowSquare > hightSquare) {//数据对比，将较大的数据装载到数组，并且移动指针
                    squares[i] = lowSquare;
                    low++;
                } else {
                    squares[i] = hightSquare;
                    hight--;
                }
            }
            return squares;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}