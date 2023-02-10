package programmercarl.array.spiralMatrix;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1
 * to n² in spiral order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 1
 * Output: [[1]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 20
 * <p>
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 935 👎 0
 */

public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        int n = 5;
        int[][] generateMatrix = solution.generateMatrix(n);
        for (int[] row : generateMatrix) {
            for (int num : row) {
                System.out.print(num + "    ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1、定义二维数组，将数据反向填入二维数组
         */
        public int[][] generateMatrix(int n) {
            int[][] generateMatrix = new int[n][n];
            int num = 1;//填入数字从1开始递增
            int start = 0;//定义起始坐标
            int loopCount = n / 2;//定义循环次数，别问为啥不是(n+1)/2,问就是正方形，单独处理奇偶
            int skip = 1;//每行行尾缩进值
            while (loopCount-- > 0) {
                //先整top 行,行固定，遍历列。行=start
                for (int left = start; left < n - skip; left++) {
                    generateMatrix[start][left] = num++;
                }
                //再整 right 列，列固定，行遍历 列=n-skip
                for (int top = start; top < n - skip; top++) {
                    generateMatrix[top][n - skip] = num++;
                }
                // 再整bottom 行，行固定，列从右往左看，行= n-skip
                for (int right = n - skip; right > start; right--) {
                    generateMatrix[n - skip][right] = num++;
                }
                // 最后整left，列固定，行从下往上看
                for (int bottom = n - skip; bottom > start; bottom--) {
                    generateMatrix[bottom][start] = num++;
                }
                start++;
                skip++;
            }
            if (n % 2 == 1) { //行列奇数正方形，中心点位置单独处理
                int mid = n / 2;
                generateMatrix[mid][mid] = num;
            }
            return generateMatrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}