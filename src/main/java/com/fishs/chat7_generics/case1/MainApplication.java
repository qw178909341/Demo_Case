package com.fishs.chat7_generics.case1;

import com.fishs.chat3.case1.examp1.model.Person;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 09:38
 */
public class MainApplication {
    public static void main(String[] args) {
        P<Integer> p = new P<Integer>(1,2);
        System.out.println(p);
    }


}


//region case1
//class  Person implements Comparable<Person> {
//    String name;
//    int score;
//    Person(String name, int score) {
//        this.name = name;
//        this.score = score;
//    }
//
//    public String toString() {
//        return name + ":" + score;
//    }
//
//    @Override
//    public int compareTo(Person o) {
//        return this.score - o.score;
//    }
//}
//endregion



class Pair<T,K>{
    T first;
    K last;

    public Pair(T first, K second) {
        this.first = first;
        this.last = second;
    }

    public Pair(){}

    public  T getFirst() {
        return first;
    }
    public  K getLast() {
        return last;
    }

    public static  <B,C> Pair<B,C> create (B first, C second) {
        return new Pair<B,C>(first, second);
    }
}

class P<T>{
    private T first;
    private T second;

    public P(T first, T second) {
        this.first =  first;
        this.second = second;
    }
    public P(){}
    public String toString() {
        return "first:" + first + " second:" + second;
    }
}

