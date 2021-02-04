import java.util.Arrays;

public class 测试 {
    public static void main(String[] args) {
        int[] a = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            a[i] = i;
        }
        Stopwatch stopwatch1 = new Stopwatch();
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        double res1 = (double) sum / a.length;
        System.out.println("stopwatch1 " + stopwatch1.elapsedTime());

        Stopwatch stopwatch2 = new Stopwatch();
        double res2 = Arrays.stream(a).average().getAsDouble();
        System.out.println("stopwatch2 " + stopwatch2.elapsedTime());
    }
}

class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start);
    }
}
