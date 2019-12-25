package myadt;

import java.util.Iterator;

/**
 * 使用链表方式实现队列
 * 先进先出 FIFO
 *
 * @author bo.chao
 * @date 2019/12/25
 */
public class MyQueue<T> implements Iterable<T> {

    private MyNode first;

    private MyNode last;

    private int size;

    // 入队
    public void enqueue(T item) {
        size ++;
        MyNode node = new MyNode();
        node.item = item;
        if (null == first) {
            first = node;
            last = node;
            return;
        }

        // 在队列尾部增加节点
        last.next = node;
        last = node;
    }

    // 出队
    public T dequeue() {
        if (null == first) {
            return null;
        }

        size --;
        MyNode item = first;
        first = first.next;
        if (null == first) {
            last = null;
        }
        return item.item;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 大小
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
        MyQueue<String> queue = new MyQueue<>();
        for (String s : testStrings) {
            if (!"-".equals(s)) {
                queue.enqueue(s);
            }
        }

        for (String s : queue) {
            System.out.println(s);
        }

    }

}
