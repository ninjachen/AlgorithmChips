package me.ninja.algorithm;

/**
 * Created by ninja_chen on 14-4-24.
 */
public class IsSquare {

    public static void main(String[] args){
            System.out.print(isSquare(625));
    }

    public static boolean isSquare(int n){
        int sum;
        for(int index = 0; index < n; index++){
            sum = index * index;
            if (sum > n) break;
            if (sum == n) {
                //System.out.println(index);
                return true;
            }
        }
        return false;
    }
}
