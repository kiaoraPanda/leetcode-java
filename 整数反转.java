public class 整数反转 {
    // 对于数字可以用数学方法对数字进行入栈出栈
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            ans = ans * 10 + pop;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toString(-234234));
        System.out.println(Integer.MIN_VALUE);
    }
}
