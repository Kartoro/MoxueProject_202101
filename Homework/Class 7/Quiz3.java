// Leetcode.933 最近的请求次数

class RecentCounter {

    Queue<Integer> times;

    public RecentCounter() {
        times = new LinkedList<>();
    }

    public int ping(int t) {

        times.offer(t);

        while (times.peek() < t -3000) {
            times.poll();
        }

        return times.size();
    }

}