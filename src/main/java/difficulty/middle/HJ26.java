package difficulty.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * HJ26 字符串排序
 * @author d3y1
 */
public class HJ26 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        while (in.hasNext()){
            String input = in.nextLine();
            String alphabet = input.replaceAll("[^a-zA-Z]", "");
            List<Character> charsList = alphabet.chars().mapToObj(c -> (char)c).collect(Collectors.toList());

            Collections.sort(charsList, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
//                    if(Character.toLowerCase(o1) == Character.toLowerCase(o2)){
//                        return 0;
//                    }else{
//                        return Character.toLowerCase(o1)-Character.toLowerCase(o2);
//                    }
                    return Character.toLowerCase(o1)-Character.toLowerCase(o2);
                }
            });

            Object[] chars = charsList.toArray();
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<input.length(); i++){
                Character aChar = input.charAt(i);
                if(Character.isAlphabetic(aChar)){
                    sb.append(chars[index++]);
                }else{
                    sb.append(aChar);
                }
            }

            System.out.println(sb);
        }
    }
}
