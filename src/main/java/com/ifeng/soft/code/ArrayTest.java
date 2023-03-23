package com.ifeng.soft.code;

import org.hibernate.metamodel.internal.JpaStaticMetaModelPopulationSetting;

/**
 * <p>TODO</p>
 *
 * @author zhangfu
 * @date 2023/3/23 下午12:02
 */
public class ArrayTest {
    /**
     *
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     */
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
        int result = search(a, target);
        System.out.println(result);
    }
}
