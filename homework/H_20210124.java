public class H_20210124 {

    public static void main(String[] args) {

        System.out.println(searchInsertLocation(new int[]{1, 3, 5, 6}, 2));


    }

    public static int searchInsertLocation(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }

        int small = 0;
        int high = nums.length - 1;

        while (small <= high) {
            int mid = (small + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                small = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return small;

    }

}
