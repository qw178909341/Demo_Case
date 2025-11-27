package com.fishs.chat8_collection.caseList.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 13:03
 */
public class Example {
    /**
     * todo 问题思考：
     *      案例如果是一组数，缺少一个数并且打乱顺序，找出这个数组中缺少的数，如果缺少的恰恰是最大或者最小数，并且不明确边际的情况下，那么有逻辑问题，因为缺少的数没办法明确到底是最小还是最大。
     *      示例：假定原始数组是 [5,6] 那么随机去掉了6 ，如果不明确这个数组是5 - 6，那么只传递一个[5],在方法中4和6 其实都满足。
     */
    // 给定一组连续的整数，例如：10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字：
    public static void main(String[] args) {
        final int start = 10;  // 起始数范围
        final int end = 20; // 结束数范围
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add( i);
        }

        list.remove((int) (Math.random() * list.size())); // 随机删除一个索引位的数据
        // 洗牌
        Collections.shuffle( list);
        System.out.println(list);
        int removeValue = findRemoveValue(list);
        System.out.println(removeValue);

        System.out.println(findRemoveValue(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10)));
    }
    public static int findRemoveValue(List<Integer> arrays){
        Integer max = Collections.max(arrays);
        Integer min = Collections.min(arrays);
        for (Integer array : arrays) {
            if (!arrays.contains(array + 1) && !array.equals(max)) {
                return array + 1;
            }
        }
        Integer expectedSum = (max + min) * (max - min + 1) / 2;  // 等差数求和，数组应该大小
        Integer actualSum = arrays.stream().mapToInt(Integer::intValue).sum();
        return expectedSum - actualSum == 0 ? min : expectedSum - actualSum;
    }


}
