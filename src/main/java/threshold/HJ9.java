package threshold;

import java.util.HashSet;
import java.util.Scanner;

/**
 * HJ9 提取不重复的整数
 * @author d3y1
 */
public class HJ9{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            HashSet<Character> digitSet = new HashSet<>();
            StringBuilder result = new StringBuilder();

            String number = new StringBuilder(in.nextLine()).reverse().toString();
            for(Character ch: number.toCharArray()){
                if(!digitSet.contains(ch)){
                    digitSet.add(ch);
                    result.append(ch);
                }
            }

            System.out.println(result);
        }
    }
}