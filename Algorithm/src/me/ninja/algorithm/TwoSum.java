package me.ninja.algorithm;

/**
 * Created by ninja_chen on 15-3-12.
 * 今日同事松茸在刷leetcode，我看了很感兴趣，先搞一道。
 * https://leetcode.com/submissions/detail/22545275/
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        //<value, index>
        Map<Integer, Integer> valueAndIndexPair  = new HashMap<>();
        //reverse value and index
        Map.Entry<Integer, Integer> entry;
        int index, value;
        Integer secondIndex;
        for (int i = 0; i < numbers.length; i++){
            secondIndex = valueAndIndexPair.put(numbers[i], i);
            if(secondIndex != null){
                if(numbers[i] == (target/2)){
                    int[] gocha = {secondIndex+1, i+1};
                    return gocha;
                }
            }
        }
        Iterator<Integer> iterator = valueAndIndexPair.keySet().iterator();

        for(;iterator.hasNext();){
            value = iterator.next();
            secondIndex = valueAndIndexPair.get(target - value);
            if(secondIndex != null){
              //gocha
                int[] gocha  = new int[2];
                if(valueAndIndexPair.get(value) < secondIndex) {
                    gocha[0] = valueAndIndexPair.get(value) + 1;
                    gocha[1] = secondIndex + 1;
                }else {
                    gocha[1] = valueAndIndexPair.get(value) + 1;
                    gocha[0] = secondIndex + 1;
                }
                return gocha;
            }
        }
        return new int[2];
    }
}
