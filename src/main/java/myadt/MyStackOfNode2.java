package myadt;

import java.util.Iterator;

/**
 * @author bo.chao
 * @date 2019/12/25
 */
public class MyStackOfNode2<T> implements Iterable<T> {

    private MyNode first;

    private MyNode last;

    private int size;

    // 入栈
    public void push(T item) {
        size ++;
        MyNode node = new MyNode();
        node.item = item;

        if (null == first) {
            first = node;
            last = node;
            return;
        }

        node.next = first;
        first = node;
    }

    // 出栈
    public T pop() {
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

    // 大小
    public int size() {
        return size;
    }


    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyNode {
        private T item;

        private MyNode next;
    }

    public static void main(String[] args) throws Exception {
        String[] testStrings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        MyStackOfNode2<String> stack = new MyStackOfNode2<>();
        for (String s : testStrings) {
            if (!"-".equals(s)) {
                stack.push(s);
            } else {
                System.out.print(stack.pop() + " ");
            }
        }
        System.out.println(stack.pop() + ", ");
        System.out.println(stack.pop() + ", ");
        System.out.println(stack.pop() + ", ");

    }
}
