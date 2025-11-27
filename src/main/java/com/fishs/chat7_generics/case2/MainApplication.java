package com.fishs.chat7_generics.case2;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 10:16
 */
public class MainApplication {
    public static void main(String[] args) {
        Pair<Double> p = new Pair<>(1.1,2.3);
        System.out.println(add(p,Double::sum));
    }
    public static <T extends Number> T add(Pair<T> p, java.util.function.BiFunction<T, T, T> combiner) {
        return combiner.apply(p.getFirst(), p.getLast());
    }
}


class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}