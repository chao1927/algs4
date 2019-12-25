package myadt;

/**
 * 定容字符串栈
 *
 * @author bo.chao
 * @date 2019/12/25
 */
public class FixCapacityStack<T> {

    private Object[] s;

    private int size;

    public FixCapacityStack(int length) throws Exception {
        if (length <= 0) {
            throw new Exception("栈大小不能小于0");
        }

        s = new Object[length];
    }

    public static void main(String[] args) throws Exception {
        String[] testStrings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        FixCapacityStack<String> stack = new FixCapacityStack<>(100);
        for (String s : testStrings) {
            if (!"-".equals(s)) {
                stack.push(s);
            } else {
                System.out.print(stack.pop() + " ");
            }
        }


        System.out.println("\r\n" + stack.size);
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
        s[size++] = i;
    }

    // 出栈
    public T pop() {
        if (size == 0) {
            return null;
        }
        return (T) s[--size];
    }

}
