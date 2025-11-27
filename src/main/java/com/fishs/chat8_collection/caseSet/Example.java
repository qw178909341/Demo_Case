package com.fishs.chat8_collection.caseSet;

import org.apache.logging.log4j.message.Message;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 16:07
 */
public class Example {
    public static void main(String[] args) {
        List<Mes> received = List.of(
                new Mes(1, "Hello!"),
                new Mes(2, "发工资了吗？"),
                new Mes(2, "发工资了吗？"),
                new Mes(3, "去哪吃饭？"),
                new Mes(3, "去哪吃饭？"),
                new Mes(4, "Bye")
        );
        List<Mes> displayMessages = process(received);
        for (Mes message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Mes> process(List<Mes> received) {
        // TODO: 按sequence去除重复消息
        Set<String> set = new HashSet<>();
        List<Mes> newList = new ArrayList<>();
        for (Mes mes : received) {
            if (set.add(mes.text)) {
                newList.add( mes);
            }
        }
        return newList;
    }
}
class Mes {
    public final int sequence;
    public final String text;
    public Mes(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}