// Leetcode.933 最近的请求次数

class RecentCounter {

    ArrayList<Integer> times;

    public RecentCounter() {
        times = new ArrayList<>();
    }

    public int ping(int t) {

        times.add(t);

        int count = 0;
        for (int each : times){

            if (each > t){
                break;
            } else if (each >= t - 3000) {
                count++;
            } else {
                continue;
            }
        }

        return count;
    }

}