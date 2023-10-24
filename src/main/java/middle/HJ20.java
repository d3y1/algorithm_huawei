package middle;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * HJ20 密码验证合格程序
 * @author d3y1
 */
public class HJ20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String result = "NG";
            String input = in.nextLine();
            char[] chars = input.toCharArray();
            int len = input.length();

            if(len > 8){
                if(kindMatch(input)){
                    boolean isDuplicated = false;
                    for (int i = 3; i < len; i++) {
                        if (input.substring(i).contains(input.substring(i - 3, i))) {
                            isDuplicated = true;
                            break;
                        }
                    }
                    if(!isDuplicated){
                        result = "OK";
                    }
                }
            }

            System.out.println(result);
        }
    }

    // 检查是否满足正则
    private static boolean kindMatch(String str){
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if(p1.matcher(str).find()){
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(str).find()){
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(str).find()){
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(str).find()){
            count++;
        }
        if(count >= 3){
            return true;
        }else{
            return false;
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()){
//            String result = "NG";
//            String input = in.nextLine();
//            char[] chars = input.toCharArray();
//            int len = input.length();
//            Set<String> kindSet = new HashSet<>();
//
//            if(len > 8){
//                for(char aChar: chars){
//                    if(Character.isUpperCase(aChar)){
//                        kindSet.add("upper");
//                    }else if(Character.isLowerCase(aChar)){
//                        kindSet.add("lower");
//                    }else if(Character.isDigit(aChar)){
//                        kindSet.add("digit");
//                    }else{
//                        kindSet.add("other");
//                    }
//                }
//
//                if(kindSet.size() >= 3){
//                    boolean isDuplicated = false;
//                    for(int i=0; i<len-5; i++){
//                        String dup = input.substring(i, i+3);
//                        int index = input.lastIndexOf(dup);
//                        if(index > i){
//                            isDuplicated = true;
//                            break;
//                        }
//                    }
//                    if(!isDuplicated){
//                        result = "OK";
//                    }
//                }
//            }
//
//            System.out.println(result);
//        }
//    }
}
