import java.util.*;

public class HomeWork_Class8 {
    //567. 字符串的排列
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] arrayCounter = new int[26];
        for(int i = 0; i < s1.length();i++){
            arrayCounter[s1.charAt(i)-'a']++;
            arrayCounter[s2.charAt(i)-'a']--;
        }
        int diff = 0;
        for(int counter : arrayCounter){
            if(counter!=0)
                diff++;
        }
        if (diff == 0) {
            return true;
        }
        for(int i = s1.length(); i < s2.length();i++){
            int index1 = s2.charAt(i)- 'a',index2 = s2.charAt(i-s1.length())-'a';
            if(index1== index2)
                continue;
            if(arrayCounter[index2] == -1)
                diff--;
            else if(arrayCounter[index2] == 0)
                diff++;

            if(arrayCounter[index1] == 1)
                diff--;
            else if(arrayCounter[index1] == 0)
                diff++;

            arrayCounter[index2]++;
            arrayCounter[index1]--;
            if(diff == 0)
                return true;



        }
        return false;
    }

    //832. 翻转图像
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        for(int i =0; i < m;i++){
            int index1 = 0, index2 = n-1;
            while(index2>index1){
                if( image[i][index1] == image[i][index2]){
                    image[i][index1] = Math.abs(image[i][index1]-1);
                    image[i][index2] = Math.abs(image[i][index2]-1);
                }
                index1++;
                index2--;
            }
            if(index2==index1){
                image[i][index1] =  Math.abs(image[i][index1]-1);;
            }
        }
        return image;

    }

    //766. 托普利茨矩阵
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 1; i < m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]!=matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }

    //1052. 爱生气的书店老板
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int count = 0;
        for(int i = 0; i < customers.length;i++){
            if(i<X)
                count = count + customers[i];
            else{
                if(grumpy[i]==0)
                    count = count + customers[i];
            }
        }
        int maxSat = count;
        for(int i=X;i<customers.length;i++){
            if(grumpy[i-X] == 1)
                count = count - customers[i-X];
            if(grumpy[i] == 1)
                count = count + customers[i];

            maxSat = Math.max(count,maxSat);
        }

        return maxSat;
    }

    //6. Z 字形变换
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<StringBuilder> strings = new ArrayList<>();
        for(int i=0;i<(numRows>s.length()?numRows:s.length());i++){
            StringBuilder string = new StringBuilder();
            strings.add(string);
        }
        int count = 0;boolean flag = true;
        for(int i=0;i<s.length();i++){
            if(count<numRows-1 && flag){

                strings.get(count).append(s.charAt(i));
                count++;
            }else if(count+1==numRows && flag){
                flag = false;
                strings.get(count).append(s.charAt(i));
                count--;

            }else if(count>0 && !flag){
                strings.get(count).append(s.charAt(i));
                count--;
            }else if(count==0 && !flag){
                flag = true;
                strings.get(count).append(s.charAt(i));
                count++;

            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder string:strings){
            result.append(string);
        }
        return result.toString();
    }

}
