// Leetcode.994 腐烂的橘子

class Solution {
    public int orangesRotting(int[][] grid) {

        ArrayList<ArrayList<Integer>> rottenIndexList = findRotten(grid);

        if (rottenIndexList == null || rottenIndexList.size() == 0){
            for (int m = 0; m < grid.length; m++){
                for (int n = 0; n < grid[0].length; n++){
                    if (grid[m][n] == 1){
                        return -1;
                    }
                }
            }
            return 0;
        }

        int result = BFS (rottenIndexList, grid);

        // 判断是否有剩余新鲜橘子
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return result;
    }


    // 初始状态下，找到所有腐烂橘子的位置
    public ArrayList<ArrayList<Integer>> findRotten (int[][] grid){
        ArrayList<ArrayList<Integer>> indexList = new ArrayList<>();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2){
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    indexList.add(index);
                }
            }
        }

        return indexList;
    }

    public int BFS (ArrayList<ArrayList<Integer>> indexList, int[][] grid){
        Queue<ArrayList<Integer>> queue = new LinkedList();

        int step = -1;

        for (ArrayList<Integer> each : indexList){
            queue.offer(each);
        }

        while (!queue.isEmpty()){
            step += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                ArrayList<Integer> current = queue.poll();
                if (current.get(0) - 1 >= 0){

                    if (grid[current.get(0) - 1][current.get(1)] == 1){
                        ArrayList<Integer> upper = new ArrayList<>();
                        upper.add(current.get(0) - 1);
                        upper.add(current.get(1));
                        grid[current.get(0) - 1][current.get(1)] = 2;
                        queue.offer(upper);
                    }
                }
                if (current.get(0) + 1 < grid.length){

                    if (grid[current.get(0) + 1][current.get(1)] == 1){
                        ArrayList<Integer> lower = new ArrayList<>();
                        lower.add(current.get(0) + 1);
                        lower.add(current.get(1));
                        grid[current.get(0) + 1][current.get(1)] = 2;
                        queue.offer(lower);
                    }
                }
                if (current.get(1) - 1 >= 0){

                    if (grid[current.get(0)][current.get(1) - 1] == 1){
                        ArrayList<Integer> left = new ArrayList<>();
                        left.add(current.get(0));
                        left.add(current.get(1) - 1);
                        grid[current.get(0)][current.get(1) - 1] = 2;
                        queue.offer(left);
                    }
                }
                if (current.get(1) + 1 < grid[0].length){

                    if (grid[current.get(0)][current.get(1) + 1] == 1){
                        ArrayList<Integer> right = new ArrayList<>();
                        right.add(current.get(0));
                        right.add(current.get(1) + 1);
                        grid[current.get(0)][current.get(1) + 1] = 2;
                        queue.offer(right);
                    }
                }

            }
        }
        return step;
    }

}