package chapter11;

import edu.princeton.cs.algs4.Bag;

/**
 * @author bo.chao
 * @date 2019/12/24
 */
public class Stats {

    public static void main(String[] args) {
        double[] nums = {0.1, 0.2, 0.3, 0.4, 0.01};

        Bag<Double> numbers = new Bag<>();
        for (double num : nums) {
            numbers.add(num);
        }

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }

        double mean = sum / nums.length;
        System.out.println(sum + ", " + mean);
    }

}
