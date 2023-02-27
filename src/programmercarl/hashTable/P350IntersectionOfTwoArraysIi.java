package programmercarl.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both
 * arrays and you may return the result in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * <p>
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * <p>
 * <p>
 * Related Topics 数组 哈希表 双指针 二分查找 排序 👍 906 👎 0
 */

public class P350IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new P350IntersectionOfTwoArraysIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Map 存储数据和出现次数
        //先处理短的数组
        //执行耗时:2 ms,击败了95.06% 的Java用户
        //	内存消耗:41.7 MB,击败了39.82% 的Java用户
        public int[] intersect(int[] nums1, int[] nums2) {
            //安全校验
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[]{};
            }
            //统一nums1 放map，nums2 对比
            //nums1 比num2 长，交换
            if (nums1.length > nums2.length) {
                int[] temps = nums1;
                nums1 = nums2;
                nums2 = temps;
            }
            //定义map，处理num1
            HashMap<Integer, Integer> num1Map = new HashMap<>();
            for (int val : nums1) {
                int count = num1Map.getOrDefault(val, 0) + 1;
                num1Map.put(val, count);
            }
            //对比num2
            List<Integer> array = new ArrayList<>();
            for (int val : nums2) {
                int count = num1Map.getOrDefault(val, 0);
                if (count > 0) {//数据在nums1 中出现过
                    array.add(val);
                    num1Map.put(val, count - 1);
                }
            }
            //array 转换成int 数组
            int[] result = new int[array.size()];
            int index = 0;
            for (int num : array) {
                result[index++] = num;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}