import java.util.HashMap;
import java.util.Map;

public class 单词规律 {
    public static boolean wordPattern(String pattern, String s) {
        char[] patternChars = pattern.toCharArray();
        String[] sStrings = s.split(" ");
        Map characterStringMap = new HashMap();
        if (pattern.length() != sStrings.length) {
            return false;
        }
        for (int i = 0; i < sStrings.length; i++) {
            if (characterStringMap.containsKey(patternChars[i])) {
                if (!characterStringMap.get(patternChars[i]).equals(sStrings[i]))
                    return false;
            } else if (characterStringMap.containsKey(sStrings[i])) {
                if (!characterStringMap.get(sStrings[i]).equals(patternChars[i]))
                    return false;
            } else {
                characterStringMap.put(patternChars[i], sStrings[i]);
                characterStringMap.put(sStrings[i], patternChars[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
