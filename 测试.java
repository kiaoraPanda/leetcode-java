import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 测试 {
    public static void main(String[] args) {
        int[] a = {};
        int x ,d , l = 0;
    }
    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder x = new StringBuilder();
            for (int j = i; j > 0; j--) {
                x.append("*");
            }
            System.out.println(x);
        }
    }
    static void plusMinus(int[] arr) {
        double length = (double)arr.length;
        int positives = 0, negatives = 0, zeros = 0;
        for (int j : arr) {
            if (j > 0) positives++;
            if (j < 0) negatives++;
            if (j == 0) zeros++;
        }
        System.out.println(positives / length);
        System.out.println(negatives / length);
        System.out.println(zeros / length);
    }
    private static String desensitizedIdNumber(String idNumber) {
        if (idNumber.length() == 15) {
            idNumber = idNumber.replaceAll("(\\w{6})\\w*(\\w{3})", "$1******$2");
        }
        if (idNumber.length() == 18) {
            idNumber = idNumber.replaceAll("(\\w{6})\\w*(\\w{3})", "$1*********$2");
        }
        return idNumber;
    }
}
