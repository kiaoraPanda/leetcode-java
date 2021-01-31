import com.sun.source.doctree.LiteralTree;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Dota2参议院 {
    public String predictPartyVictory(String senate) {
        int sLength = senate.length();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            }
            else {
                dQueue.offer(i);
            }
        }
        while (true){
            if (dQueue.isEmpty()) {
                return "Radiant";
            }
            else if (rQueue.isEmpty()) {
                return "Dire";
            }
            else {
                if (dQueue.peek() < rQueue.peek()) {
                    rQueue.poll();
                    int tempD = dQueue.remove();
                    tempD += sLength;
                    dQueue.offer(tempD);
                }else {
                    dQueue.poll();
                    int tempD = rQueue.remove();
                    tempD += sLength;
                    rQueue.offer(tempD);
                }
            }
        }
    }

    public static void main(String[] args) {
        Dota2参议院 a = new Dota2参议院();
        System.out.println(a.predictPartyVictory("DR"));
    }
}
