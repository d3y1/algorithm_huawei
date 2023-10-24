package simple;

import java.util.HashSet;
import java.util.Scanner;

public class HJ81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String S = in.nextLine();
        String T = in.nextLine();

        char[] charsS = S.toCharArray();
        char[] charsT = T.toCharArray();

        HashSet<Character> sSet = new HashSet<>();
        HashSet<Character> tSet = new HashSet<>();

        for(char aChar: charsS){
            sSet.add(aChar);
        }
        for(char aChar: charsT){
            tSet.add(aChar);
        }

        if(sSet.size() > tSet.size()){
            System.out.print("false");
        }else{
            if(tSet.containsAll(sSet)){
                System.out.print("true");
            }else{
                System.out.print("false");
            }
        }
    }
}
