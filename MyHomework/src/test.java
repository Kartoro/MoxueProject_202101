import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class test {
    public String shuixianhua(int number){
        int number1,number2,number3;
        number1 = number/100;
        number2 = number%100/10;
        number3 = number%100%10;
        int numberSum = (int)(Math.pow(number1,3)+Math.pow(number2,3)+Math.pow(number3,3));
        if(number == numberSum)
            return number+"是水仙花数";
        else
            return number+"不是水仙花数";

    }

        public int majorityElement(int[] nums) {
            HashMap<Integer,Integer> numberCounts = new HashMap<>();
            for(int i : nums){
                if(numberCounts.containsKey(i)){
                    numberCounts.put(i,numberCounts.get(i)+1);
                }else{
                    numberCounts.put(i,1);
                }
            }

            for(Integer numberKey : numberCounts.keySet()){
                if(numberCounts.get(numberKey)>nums.length/2)
                    return numberKey;
            }
            return 0;
        }


    public boolean isValid(String s) {
        String[] strArray = s.split( "" );
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArray));
        boolean flag = true;
        if(arrayList.size()%2!=0){
            return false;
        }
        while(arrayList.size()!=0 && flag){
            if(arrayList.contains("{") && arrayList.contains("}")){
                arrayList.remove("{");
                arrayList.remove("}");
            }
            else  if(arrayList.contains("[") && arrayList.contains("]")){
                arrayList.remove("[");
                arrayList.remove("]");
            }
            else  if(arrayList.contains("(") && arrayList.contains(")")){
                arrayList.remove("(");
                arrayList.remove(")");
            }
            else {flag = false;}


        }
        return arrayList.size() == 0;
    }

    public String largestNumber(int[] nums) {
        for(int i = 0; i< nums.length-1;i++){
            for (int j = i+1; j<nums.length;j++){
                if (Integer.parseInt((i+"")+(j+"")) < Integer.parseInt(((j+"")+(i+"")))){
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
        }
        String result = "";
        for (int i : nums){
            result = result + (i+"");
        }
        return result;
    }
}
