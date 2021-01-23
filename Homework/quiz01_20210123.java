1. [intro] 水仙花数
打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。

public class ShuiXian{
    public static void main(String args[]){
        for(int x = 1; x < 10; x++){
            for(int y = 0; y < 10; y++){
                for int z = 0; z < 10; z++){
                    if (x^3 + y^3 + z^3 = 100x + 10y + z){
                        System.out.print(100x + 10y + z)
                    }
                }
            }
        }
    }
}


2. [easy] 多数元素 lc.169
class Solution {
    public int majorityElement(int[] nums) {
        Scanner sc = new Scanner(System.in);
        String[] nums = null;
        nums = sc.nextLine().split(",");
        int num[] = new int[nums.length];
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.valueOf(nums[i])
        }

    }
}

3. [easy] 有效的括号 lc.20

4. [medium] 最大数 lc.179

*5. [hard] 二叉树中的最大路径和 lc.124