public class J_424 {

    public int characterReplacement(String s, int k) {
        int[] cha = new int[26];
        int right =0;
        int left =0;
        int max =0;
        while (right < s.length()){
            cha[s.charAt(right)-'A']++;
            max = Math.max(max,cha[s.charAt(right)-'A']);

        if(right-left+1 > max+k){
            cha[s.charAt(left)-'A']--;
            left++;

        }
        right++;
        }
        return right-left;
    }
}
