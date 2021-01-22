import java.util.Queue;
import java.util.LinkedList;

public class HotPotato {
    public static String hotPotato(String names[], int num) {
        Queue<String> gameQueue =  new LinkedList<String>();
        int numOfNames = names.length;

        for (int i = 0; i < numOfNames; i++) {
            gameQueue.add(names[i]);
        }

        while (gameQueue.size() > 1) {
            for (int i = 0; i < num; i++) {
                gameQueue.add(gameQueue.peek());
                gameQueue.poll();
            }

            gameQueue.poll();
        }

        return gameQueue.peek();
    }
    
    public static void main(String args[]) {
        String names[] = {"A", "B", "C", "D", "E", "F"};
        
        System.out.println(hotPotato(names, 7)); // Output: C
    }
}
