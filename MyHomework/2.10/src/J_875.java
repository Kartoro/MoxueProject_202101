public class J_875 {
    public int minEatingSpeed(int[] piles, int H) {
        for(int i =1; i >=1; i++){
            if(finish(piles,H,i)){
                return i;
            }

        }
        return -1;
    }

    public boolean finish(int[] piles, int H, int k){
        int time = 0;
        for(int i =0; i <piles.length; i ++){
            if(piles[i]%k >0){
                time = time + piles[i]/k+1;
            }  else{
                time = time + piles[i]/k;

            }
            if(time !=H){
                return false;

            }        }
    return true;
    }
}
