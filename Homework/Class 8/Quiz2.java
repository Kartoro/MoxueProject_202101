// Leetcode.832 翻转图像

class Solution {
	
    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++){
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < image[0].length; j++){
                stack.push(image[i][j]);
            }
            for (int j = 0; j < image[0].length; j++){
                if (stack.pop() == 0){
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
            }
        }

        return image;

    }
}