package programmercarl.array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left
 * to right. The trees are represented by an integer array fruits where fruits[i]
 * is the type of fruit the iᵗʰ tree produces.
 * <p>
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * <p>
 * <p>
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked fruits
 * must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * <p>
 * <p>
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= fruits.length <= 10⁵
 * 0 <= fruits[i] < fruits.length
 * <p>
 * <p>
 * Related Topics 数组 哈希表 滑动窗口 👍 435 👎 0
 */

public class P904FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new P904FruitIntoBaskets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗+数组，数组中存储每个元素出现的次数
        //执行耗时:7 ms,击败了76.20% 的Java用户
        //内存消耗:49.3 MB,击败了87.35% 的Java用户
        public int totalFruit(int[] fruits) {
            int left = 0, right = 0;//滑动窗口的左右边界
            int maxLength = 0;// 滑动窗口的最大距离
            // Map<Integer, Integer> fruitMap = new HashMap<Integer, Integer>(); //水果篮，用于存放水果种类和个数
            int[] fruitsBasket = new int[fruits.length];//水果篮，下标为水果种类，内容为水果数量
            int fruitType = 0;//水果种类

            for (; right < fruits.length; right++) {//滑动窗口右边界一直往右移动
                // 往水果篮里放水果。<水果种类、水果数量+1>
                // 判断是不是新来了一种水果
                if (fruitsBasket[fruits[right]] == 0) {
                    fruitType++;
                }
                fruitsBasket[fruits[right]]++; // 水果加一
                // 判断水果篮里面的水果种类是否大于2中
                while (fruitType > 2) {//水果种类大于2中
                    //滑动左边界开始移动，依次从水果篮里面扔水果，一直扔到某个种类的水果没有位置
                    fruitsBasket[fruits[left]]--;
                    if (fruitsBasket[fruits[left]] == 0) {
                        //水果篮里该种类水果数量为0，该种类移除
                        fruitType--;
                    }
                    left++;

                }
                maxLength = Math.max(maxLength, (right - left) + 1);
            }
            return maxLength;
        }

        //滑动窗口+Map 去重
        //执行耗时:49 ms,击败了27.87% 的Java用户
        //内存消耗:51 MB,击败了15.58% 的Java用户
        public int totalFruitSlow(int[] fruits) {
            int left = 0, right = 0;//滑动窗口的左右边界
            int maxLength = 0;// 滑动窗口的最大距离
            Map<Integer, Integer> fruitMap = new HashMap<Integer, Integer>(); //水果篮，用于存放水果种类和个数

            for (; right < fruits.length; right++) {//滑动窗口右边界一直往右移动
                // 往水果篮里放水果。<水果种类、水果数量+1>
                //fruitMap.put(fruits[right], fruitMap.get(fruits[right]) + 1);
                fruitMap.put(fruits[right], fruitMap.getOrDefault(fruits[right],0) + 1);//给水果篮默认初始值0
                // 判断水果篮里面的水果种类是否大于2中
                while (fruitMap.size() > 2) {//水果种类大于2中
                    //滑动左边界开始移动，依次从水果篮里面扔水果，一直扔到某个种类的水果没有位置
                    fruitMap.put(fruits[left], fruitMap.get(fruits[left]) - 1);//从水果篮里面扔水果，<水果种类、水果数量-1>
                    if (fruitMap.get(fruits[left]) == 0) {
                        //水果篮里该种类水果数量为0，该种类移除
                        fruitMap.remove(fruits[left]);
                    }
                    left++;

                }
                maxLength = Math.max(maxLength, (right - left) + 1);
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}