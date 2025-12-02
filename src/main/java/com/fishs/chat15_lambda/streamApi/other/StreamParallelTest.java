package com.fishs.chat15_lambda.streamApi.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 测试Stream 并行流的性能
 * @Author: lf
 * @Date: 2025/12/2 11:58
 */
public class StreamParallelTest {
    // 测试数据量（1000 万条，可根据机器性能调整）
    private static final int DATA_SIZE = 99999999;
    // 测试执行次数（取平均值，减少误差）
    private static final int TEST_TIMES = 10;

    /**
     * 初始化测试数据：生成 1000 万条随机整数（1-1000）
     */
    private List<Integer> generateTestData() {
        List<Integer> dataList = new ArrayList<>(DATA_SIZE);
        for (int i = 0; i < DATA_SIZE; i++) {
            // 生成 1-1000 的随机整数
            dataList.add((int) (Math.random() * 1000) + 1);
        }
        return dataList;
    }

    /**
     * 模拟 CPU 密集型任务：复杂计算（质数判断 + 平方和）
     * 目的：让 CPU 有足够的计算量，凸显并行优势
     */
    private long cpuIntensiveTask(List<Integer> dataList, boolean isParallel) {
        // 选择串行流或并行流
        var stream = isParallel ? dataList.parallelStream() : dataList.stream();

        // 任务逻辑：筛选质数 → 计算平方 → 求和
        return stream
                .filter(this::isPrime) // 筛选质数（CPU 密集）
                .mapToLong(num -> (long) num * num) // 计算平方
                .sum(); // 求和
    }

    /**
     * 辅助方法：判断一个数是否为质数（CPU 密集操作）
     */
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        // 只判断到根号 num，减少计算量但保留 CPU 消耗
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * 性能测试核心方法：统计单次执行时间
     */
    private long testExecuteTime(List<Integer> dataList, boolean isParallel) {
        long startTime = System.currentTimeMillis();
        // 执行任务（结果不重要，重点是执行时间）
        cpuIntensiveTask(dataList, isParallel);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * 主测试方法：对比串行流和并行流的性能
     */
    @Test
    public void testParallelVsSequential() {
        // 1. 初始化测试数据（只初始化一次，避免重复消耗）
        System.out.println("开始初始化测试数据（" + DATA_SIZE + " 条）...");
        List<Integer> testData = generateTestData();
        System.out.println("数据初始化完成！\n");

        // 2. 测试串行流（Sequential）
        System.out.println("=== 串行流（Sequential）测试 ===");
        long sequentialTotal = 0;
        for (int i = 0; i < TEST_TIMES; i++) {
            long time = testExecuteTime(testData, false);
            sequentialTotal += time;
            System.out.println("第 " + (i + 1) + " 次执行时间：" + time + " ms");
        }
        long sequentialAvg = sequentialTotal / TEST_TIMES;
        System.out.println("串行流平均执行时间：" + sequentialAvg + " ms\n");

        // 3. 测试并行流（Parallel）
        System.out.println("=== 并行流（Parallel）测试 ===");
        long parallelTotal = 0;
        for (int i = 0; i < TEST_TIMES; i++) {
            long time = testExecuteTime(testData, true);
            parallelTotal += time;
            System.out.println("第 " + (i + 1) + " 次执行时间：" + time + " ms");
        }
        long parallelAvg = parallelTotal / TEST_TIMES;
        System.out.println("并行流平均执行时间：" + parallelAvg + " ms\n");

        // 4. 计算性能提升比例
        double speedUpRatio = (sequentialAvg - parallelAvg) * 100.0 / sequentialAvg;
        System.out.println("=== 性能对比结果 ===");
        System.out.println("串行流平均：" + sequentialAvg + " ms");
        System.out.println("并行流平均：" + parallelAvg + " ms");
        System.out.println("性能提升：" + String.format("%.2f", speedUpRatio) + "%");
    }
}
