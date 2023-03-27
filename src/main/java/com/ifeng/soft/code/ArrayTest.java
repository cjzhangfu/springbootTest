package com.ifeng.soft.code;

/**
 * <p>数组算法</p>
 *
 * @author zhangfu
 * @date 2023/3/23 下午12:02
 */
public class ArrayTest {
    /**
     * 1.折半查找
     * <p>
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     */
    static class HalfSearchTest {
        public static int halfSearch(int[] nums, int target) {
            // 1.定义目标元素的区间，head 和tail 头和尾部
            // 2.当head<=tail的时候，去进行取中位数比较
            // 3.如果中间数据>target 则目标区间在[head,mid-1]
            // 4.如果中间数据<target 则目标区间在[mid+1,tail]
            int head = 0;
            int tail = nums.length - 1;
            while (head <= tail) {
                int mid = tail - head / 2;
                int query = nums[mid];
                if (query < target) {
                    head = mid + 1;
                } else if (query > target) {
                    tail = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;

        }

        public static void main(String[] args) {
            int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
            int target = 5;
            int result = halfSearch(a, target);
            System.out.println(result);
        }
    }

    /**
     * 2.移除元素
     * LeetCode-27
     *
     * <p>
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素
     *
     * @return
     */
    static class RemoveItemTest {
        // 使用快慢指针
        public static int removeItem(int[] nums, int val) {
            // 1.记录不为val的位置
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            return index;
        }

        // 使用双向指针
        public static int removeItemDouble(int[] nums, int val) {
            int head = 0;
            int tail = nums.length - 1;
            while (tail >= 0 && nums[tail] == val) {
                tail--;
            }
            while (head <= tail) {
                if (nums[head] == val) {
                    nums[head] = nums[tail];
                    tail--;
                }
                head++;
                while (tail >= 0 && nums[tail] == val) {
                    tail--;
                }
            }
            return head;
        }

        public static void main(String[] args) {
            int[] a = new int[]{1, 1, 3, 4, 5, 1, 7};
            int target = 1;
//            int nums = removeItem(a, target);
//            System.out.println(nums);
//            System.out.println(a.toString());

            int doubles = removeItemDouble(a, target);
            System.out.println(doubles);
        }
    }

    /**
     * 3.有序数组的平方
     * LeetCode-977
     * <p>
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <p>
     * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
     * <p>
     * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
     * <p>
     * 思路一，先将数据去除符号排序，然后进行平方
     * <p>
     * 思路二：双向指针，前后比较，把最大的放新数组的最后一位
     * <p>
     * #
     */
    static class SortedSquaresTest {
        public static int[] sortedSquares(int[] a) {
            int head = 0;
            int tail = a.length - 1;
            int[] result = new int[a.length];
            int index = result.length - 1;
            while (head <= tail) {
                // 1.头部元素大于尾部元素
                if (a[head] * a[head] > a[tail] * a[tail]) {
                    result[index] = a[head] * a[head];
                    head++;
                } else {
                    // 头部元素小于尾部元素
                    result[index] = a[tail] * a[tail];
                    tail--;
                }
                index--;
            }
            return result;
        }

        public static void main(String[] args) {
            int[] a = new int[]{-4, -3, 0, 1, 3, 5, 6};
            int[] b = sortedSquares(a);
            for (int item : b) {
                System.out.println(item);
            }
        }
    }

    /**
     * 4.长度最小的子数组
     * LeetCode-209
     *
     * <p>
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * <p>
     * 示例：
     * <p>
     * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * <p>
     * 提示：
     * <p>
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     * <p>
     * 思路：
     */
    static class MinSubArrayLenTest {
        public static int minSubArrayLen(int[] a, int target) {
            int result = Integer.MAX_VALUE;
            // 滑动窗口的头部
            int head = 0;
            // 滑动窗口的数值只和
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i];
                while (sum >= target) {
                    int size = i - head + 1;
                    if (size < result) {
                        result = size;
                    }
                    sum -= a[head];
                    head++;
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }

        public static void main(String[] args) {
            int[] a = new int[]{2, 3, 1, 2, 4, 3};
            int size = minSubArrayLen(a, 3);
            System.out.println(size);
        }
    }

    /**
     * 5.螺旋矩阵II
     * LeetCode-59
     * <p>
     * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * <p>
     * 示例:
     * <p>
     * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
     * <p>
     * #
     */
    static class GenerateMatrixTest {
        public static void generateMatrix(int n) {

        }
    }
}
