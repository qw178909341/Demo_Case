package com.fishs.chat4.case1;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/24 14:14
 */
public class ExamApplication {
    public static void main(String[] args) {
        try {
            System.out.println("准备做一个危险行为：10 / 0");
            int x = 10 / 0; // 触发 ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("第一层捕获：除数不能为 0");
            // 再抛一个新的异常，让后面的 catch 继续处理
            throw new RuntimeException("重新抛出 RuntimeException");
        } catch (RuntimeException e) {  // 这里不会执行，因为第一层已经处理了
            System.out.println("第二层捕获：捕获到 RuntimeException：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("最宽泛的捕获：Exception");
        }

        System.out.println("程序继续运行...");
    }
}
