import java.util.ArrayDeque;
import java.util.Queue;

public class J_933 {
    private Queue<Integer> queue;
    public RecentCounter() {
            queue = new ArrayDeque<>();

    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t - 3000) {
            queue.remove();
        }
        return queue.size();
    }


}
