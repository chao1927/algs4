package myadt;

import java.util.Iterator;

/**
 * @author bo.chao
 * @date 2019/12/25
 */
public class MyStackOfNode<T> implements Iterable<T> {

    // 开始节点
    private MyNode first;

    // 结束节点
    private MyNode last;

    // 大小
    private int size;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

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

        last.next = node;
        node.previous = last;
        last = node;
    }

    // 出栈
    public T pop() {
        if (null == last) {
            return null;
        }

        size --;
        MyNode item = last;
        if (null == last.previous) {
            last = null;
            first = null;
        } else {
            last = last.previous;
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

    private class MyNode {

        private T item;

        private MyNode next;

        private MyNode previous;
    }

    public static void main(String[] args) throws Exception {
        String[] testStrings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        MyStackOfNode<String> stack = new MyStackOfNode<>();
        for (String s : testStrings) {
            if (!"-".equals(s)) {
                stack.push(s);
            } /*else {
                System.out.print(stack.pop() + " ");
            }*/
        }
        System.out.println();

    }



}
