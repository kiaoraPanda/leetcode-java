public class 删除回文子序列 {

    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] sChars = s.toCharArray();
        int middle;
        if (s.length() % 2 == 1) {
            middle = (sChars.length - 2) / 2;
        }
        else {
            middle = (sChars.length - 1) / 2;
        }

        for (int i = 0; i <= middle; i++) {
            if (sChars[i] != sChars[sChars.length - i - 1]) {
                return 2;
            }
        }

        return 1;
    }

    // 遍历到字符串数组的中间其实只需要 长度减一除二
    public int removePalindromeSub2(String s) {
        int length = s.length() - 1;
        if (length == -1) return 0;
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i)) {
                return 2;
            }
        }
        return 1;
    }


}
