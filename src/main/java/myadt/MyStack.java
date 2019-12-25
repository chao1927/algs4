package myadt;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author bo.chao
 * @date 2019/12/25
 */
public class MyStack<T> implements Iterable<T> {

    private Object[] s;

    private int size;

    public MyStack() {
        s = new Object[10];
    }

    public MyStack(int length) throws Exception {
        if (length <= 0) {
            throw new Exception("栈大小不能小于0");
        }

        s = new Object[length];
    }

    public static void main(String[] args) throws Exception {
        String[] testStrings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        MyStack<String> stack = new MyStack<>(4);
        for (String s : testStrings) {
            if (!"-".equals(s)) {
                stack.push(s);
            } else {
                System.out.print(stack.pop() + " ");
            }
        }

        System.out.println();

        for (String s : stack) {
            System.out.println(s);
        }
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 大小
    public int size() {
        return size;
    }

    // 入栈
    public void push(T i) {
        if (size == s.length) {
            resize(2 * size + 1);
        }

        s[size++] = i;
    }

    // 出栈
    public T pop() {
        if (size == 0) {
            return null;
        }
        T item = (T) s[--size];
        s[size] = null;
        if (size > 0 && size == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    private void resize(int max) {
        s = Arrays.copyOf(s, max);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return (T) s[--i];
        }
    }
}
