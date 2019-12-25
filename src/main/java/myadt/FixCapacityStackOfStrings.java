package myadt;

/**
 * 定容字符串栈
 *
 * @author bo.chao
 * @date 2019/12/25
 */
public class FixCapacityStackOfStrings {

    private String[] s;

    private int size;

    public FixCapacityStackOfStrings(int length) throws Exception {
        if (length <= 0) {
            throw new Exception("栈大小不能小于0");
        }

        s = new String[length];
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 栈是否已满
    public boolean isFull() {
        return size == s.length;
    }

    // 大小
    public int size() {
        return size;
    }

    // 入栈
    public void push(String item) throws Exception {
        if (size == s.length) {
            throw new Exception("栈已满");
        }

        s[size++] = item;
    }

    // 出栈
    public String pop() {
        if (size == 0) {
            return null;
        }
        return s[--size];
    }


}
