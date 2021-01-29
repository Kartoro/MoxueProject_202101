package com.company;

public class Quize01 {

    public void quiz(){
    int l;
    for(int i=1;i<=9;i++){
        for(int j=0;j<=9;j++){
            for(int k=0;k<=9;k++){
                if(Math.pow(i,3)+Math.pow(j,3)+Math.pow(k,3)==i*100+j*10+k){
                    l=i*100+j*10+k;
                    System.out.println(l);
                }
            }
        }
    }
}

}
