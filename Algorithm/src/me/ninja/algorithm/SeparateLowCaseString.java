package me.ninja.algorithm;

/**
 * Created by ninja_chen on 14-4-24.
 *
 * 有一个由大小写组成的字符串，现在需要对他进行修改，将其中的所有小写字母排在大写字母的前面（大写或小写字母之间不要求保持原来次序.
 * 如有可能尽量选择时间和空间效率高的算法 c语言函数原型void proc（char *str） 也可以采用你自己熟悉的语言
 */
public class SeparateLowCaseString {

    public static void main(String[] args){
        System.out.print(separateLowCaseString("abCCCSSSSSSxsdfsadTTTaSSS"));
    }

    public static String separateLowCaseString(String origin){
        char[] s = origin.toCharArray();
        char[] low = new char[s.length * 2];
        char[] upper = new char[s.length];
        int lcount = 0, ucount = 0;
        char temp;
        for (int index = 0; index < s.length; index++){
            temp = s[index];
            if(temp > 64 && temp < 91){
                // 65~90 A~Z
                upper[ucount] = temp;
                ucount++;
            }

            if(temp > 96 && temp < 113 ){
                //97~112 a~z
                low[lcount] = temp ;
                lcount++;
            }
        }

        for(int index = 0; index < ucount; index++){
            low[lcount + index] = upper[index];
        }
        return String.valueOf(low);
    }
}
