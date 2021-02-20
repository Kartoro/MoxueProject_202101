public class substring {
    public static void main(String[] args){


        System.out.println(maxRepeating("ababc","ba"));
    }
    public static int maxRepeating(String sequence, String word) {
        int len = word.length();
        int left =0;
        int right =len-1;
        int k =0;
        while(right<sequence.length()){
            StringBuffer tem =  new StringBuffer();
            for(int i = 0; i < len; i++){
                tem.append(sequence.charAt(i+left));
            }
            if(word.equals(tem.toString())){
                k++;
            }
            left++;
            right++;
        }

        return k;

    }
}
