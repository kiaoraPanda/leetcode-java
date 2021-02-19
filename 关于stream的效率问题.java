import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 关于stream的效率问题 {
    public static void main(String[] args) {
//        for (int j = 1; j < 10; j++) {
//            int[] a = new int[(int) (1000 * Math.pow(10, j))];
//
//            for (int i = 0; i < 1000 * j; i++) {
//                a[i] = i;
//            }
//            Stopwatch stopwatch1 = new Stopwatch();
//            int sum = 0;
//            for (int i : a) {
//                sum += i;
//            }
//            double res1 = (double) sum / a.length;
//            System.out.println("stopwatch1 " + j + " " + stopwatch1.elapsedTime());
//
//            Stopwatch stopwatch2 = new Stopwatch();
//            double res2 = Arrays.stream(a).average().getAsDouble();
//            System.out.println("stopwatch2 " + j + " " + stopwatch2.elapsedTime());
//        }

        // 1000的指数幂递增
//        for (int j = 0; j < 10; j++) {
//            List<Integer> a = new ArrayList<>();
//
//            for (int i = 0; i < 1000 * Math.pow(10, j); i++) {
//                a.add(i);
//            }
//            Stopwatch stopwatch1 = new Stopwatch();
//            int sum = 0;
//            for (int i : a) {
//                sum += i;
//            }
//            double res1 = (double) sum / a.size();
////            System.out.println("stopwatch1 " + j + " " + stopwatch1.elapsedTime());
//            double p = stopwatch1.elapsedTime();
//            Stopwatch stopwatch2 = new Stopwatch();
//            double res2 = a.stream().mapToLong(a::get).average().getAsDouble();
////            System.out.println("stopwatch2 " + j + " " + stopwatch2.elapsedTime());
//            double k = stopwatch2.elapsedTime();
//            a = null;
//            System.out.println("流和for循环的时间差 " + j + " " + (k - p));

        // 100000000 这个量级 加 10000000 递增
//        for (int j = 0; j < 10; j++) {
//            List<Integer> a = new ArrayList<>();
//
//            for (int i = 0; i < 100000000 + (10000000 * j); i++) {
//                a.add(i);
//            }
//            Stopwatch stopwatch1 = new Stopwatch();
//            int sum = 0;
//            for (int i : a) {
//                sum += i;
//            }
//            double res1 = (double) sum / a.size();
////            System.out.println("stopwatch1 " + j + " " + stopwatch1.elapsedTime());
//            double p = stopwatch1.elapsedTime();
//            Stopwatch stopwatch2 = new Stopwatch();
//            double res2 = a.stream().mapToLong(a::get).average().getAsDouble();
////            System.out.println("stopwatch2 " + j + " " + stopwatch2.elapsedTime());
//            double k = stopwatch2.elapsedTime();
//            a = null;
//            System.out.println("流和for循环的时间差 " + j + " " + (k - p));
//        }

        // 100000000 这个量级恒定
//        for (int j = 0; j < 100; j++) {
//            List<Integer> a = new ArrayList<>();
//
//            for (int i = 0; i < 100000000; i++) {
//                a.add(i);
//            }
//            Stopwatch stopwatch1 = new Stopwatch();
//            int sum = 0;
//            for (int i : a) {
//                sum += i;
//            }
//            double res1 = (double) sum / a.size();
//            double p = stopwatch1.elapsedTime();
//
//            Stopwatch stopwatch2 = new Stopwatch();
//            double res2 = a.stream().mapToLong(a::get).average().getAsDouble();
////            System.out.println("stopwatch2 " + j + " " + stopwatch2.elapsedTime());
//            double k = stopwatch2.elapsedTime();
//
//            System.out.println("流和for循环的时间差 " + j + " " + (k - p));
//
//            a = null;
//            stopwatch1 = null;
//            stopwatch2 = null;
//            System.gc();
//        }

        // 数量级指数递增，每个量级算平均值
//        for (int q = 0; q < 6; q++) {
//            double n = 1000 * Math.pow(10, q);
//            double[] temp = new double[100];
//            for (int j = 0; j < 100; j++) {
//                List<Integer> a = new ArrayList<>();
//                for (int i = 0; i < n; i++) {
//                    a.add(i);
//                }
//
//                Stopwatch stopwatch1 = new Stopwatch();
//                int sum = 0;
//                for (int i : a) {
//                    sum += i;
//                }
//                double res1 = (double) sum / a.size();
//                double p = stopwatch1.elapsedTime();
//
//                Stopwatch stopwatch2 = new Stopwatch();
//                double res2 = a.stream().mapToLong(a::get).average().getAsDouble();
//                double k = stopwatch2.elapsedTime();
//
//                temp[j] = k - p;
//
//            }
//            double average = Arrays.stream(temp).average().getAsDouble();
//            System.out.println("数量级为1000 * 10^" + q + " 平均时间差为 " + average);
//        }
        System.out.println(LocalDateTime.now());
        // 指数递增上限为4 重复次数为1000
        for (int q = 0; q < 5; q++) {
            double n = 1000 * Math.pow(10, q);
            double[] temp = new double[10000];
            for (int j = 0; j < 10000; j++) {
                List<Integer> a = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    a.add(i);
                }

                Stopwatch stopwatch1 = new Stopwatch();
                int sum = 0;
                for (int i : a) {
                    sum += i;
                }
                double res1 = (double) sum / a.size();
                double p = stopwatch1.elapsedTime();

                Stopwatch stopwatch2 = new Stopwatch();
                double res2 = a.stream().mapToLong(a::get).average().getAsDouble();
                double k = stopwatch2.elapsedTime();

                temp[j] = k - p;

            }
            double average = Arrays.stream(temp).average().getAsDouble();
            System.out.println("数量级为1000 * 10^" + q + " 平均时间差为 " + average);
        }
        System.out.println(LocalDateTime.now());


    }
}
