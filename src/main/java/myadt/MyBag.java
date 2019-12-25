package myadt;

import java.util.Iterator;

/**
 * @author bo.chao
 * @date 2019/12/25
 */
public class MyBag<T> implements Iterable<T> {

    private MyNode first;

    private int size;

    public void add(T item) {
        size ++;
        MyNode node = new MyNode();
        node.item = item;
        if (null == first) {
            first = node;
            return;
        }
        node.next = first;
        first = node;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class MyNode {
        private T item;

        private MyNode next;
    }

    private class ListIterator implements Iterator<T> {

        private MyNode current = first;

        @Override
        public boolean hasNext() {
            return null != current;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] testStrings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        MyBag<String> queue = new MyBag<>();
        for (String s : testStrings) {
            if (!"-".equals(s)) {
                queue.add(s);
            }
        }

        for (String str : queue) {
            System.out.println(str);
        }
    }
}
