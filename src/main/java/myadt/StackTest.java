package myadt;

import edu.princeton.cs.algs4.Stack;

/**
 * @author bo.chao
 * @date 2019/12/25
 */
public class StackTest {

    // 测试栈, 算术表达式求值
    // 双栈, 运算符栈 + 操作数栈
    // 1. 将操作数压入操作数栈
    // 2. 将运算符压入运算符栈
    // 3. 忽略左括号
    // 4. 遇到左括号, 弹出一个运算符, 弹出所需数量的操作数, 并将这些运算符和操作数的计算结果压入栈.

    // (1 + ((2 + 3) * (4*5))

    public static void main(String[] args) {
        String[] target = {"(", "1", "+", "(", "(", "2", "+", "3", ")", "*", "(", "4", "*", "5", ")", ")"};

        // 运算符栈
        Stack<String> ops = new Stack<>();

        // 操作数栈
        Stack<Double> vals = new Stack<>();

        String defaultOps = "+-*/sqrt";

        for (String str : target) {
            if ("(".equals(str)) {
                continue;
            }

            if (defaultOps.contains(str)) {
                ops.push(str);
            } else if (")".equals(str)) {
                String op = ops.pop();
                double val = vals.pop();
                switch (op) {
                    case "+":
                        val = vals.pop() + val;
                        break;
                    case "-":
                        val = vals.pop() - val;
                        break;
                    case "*":
                        val = vals.pop() * val;
                        break;
                    case "/":
                        val = vals.pop() / val;
                        break;
                    case "sqrt":
                        val = Math.sqrt(val);
                    default:
                }
                vals.push(val);
            } else {
                vals.push(Double.parseDouble(str));
            }

        }
        System.out.println(vals.pop());
    }

}
