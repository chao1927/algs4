package chapter11;

/**
 * @author bo.chao
 * @date 2019/12/20
 */
public class Practice1Test {

    public static void main(String[] args) {
        // 1.1.1
        // a
//        System.out.println((0 + 15) / 2);
        // b
//        System.out.println(2.0e-6*100000000.1);
        // c
//        System.out.println(true && false || true && true);

        // 1.1.2
        // a
//        System.out.println((1 + 2.236)/2);
        // b
//        System.out.println(4.1 >= 4);
        // c
//        System.out.println(1 + 2 + "3");

        // 1.1.3
//        testEqual(1, 1, 1);

        // 1.1.5
//        test0To1(0.2, 0.1);

        // 1.1.6
//        test117a();

//        // 1.18
//        System.out.println((char) ('a' + 4));

//        test1113();

//        System.out.println(factorialR(5));

        Number[] nums = new Integer[10];
        nums[0] = new Float(10.0);
        System.out.println(nums[0]);
    }

    public static void testEqual(int a, int b, int c) {
        if (a == b && b == c) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    public static void test0To1(double x, double y) {
        System.out.println(x > 0.0 && x < 1.0 && y > 0.0 && y < 1.);
    }

    //
    public static void test116() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void test117a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        System.out.println(t);

    }

    public static void test1113() {
        int[][] a = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5},
                {3, 6}
        };

        // 最长数组
        int maxLength = -1;
        for (int[] aArr : a) {
            if (aArr.length >= maxLength) {
                maxLength = aArr.length;
            }
        }

        int[][] b = new int[maxLength][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][i] = a[i][j];
            }
        }

        for (int[] bArr : b) {
            for (int bbb : bArr) {
                System.out.print(bbb + " ");
            }
            System.out.println();
        }

    }

    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static int factorialR(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialR(n - 1);
    }

}
