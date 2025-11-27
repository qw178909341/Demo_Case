package com.fishs.chat8_collection.caseIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 17:48
 */
public class Demo {
    static void main() {
        ReverseList<String> rlist = new ReverseList<>();
        rlist.add("Apple");
        rlist.add("Orange");
        rlist.add("Pear");
        for (String s : rlist) {
            System.out.println(s);
        }
    }
}
class ReverseList<T> implements Iterable<T> {
    private List<T> list = new ArrayList<>();
    public void add(T t){
        list.add(0, t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {
        int index;
        public ReverseIterator(int  index){
            this.index = index;
        }
        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get( index);
        }
    }
}