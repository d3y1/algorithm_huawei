package difficulty.simple;

import java.util.Scanner;

public class HJ84 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.print(input.replaceAll("[^A-Z]","").length());
    }



    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);

    //     String input = in.nextLine();
    //     char[] chars = input.toCharArray();

    //     int count = 0;
    //     for(char achar: chars){
    //         // if('A'<=achar && achar<='Z'){
    //         if(Character.isUpperCase(achar)){
    //             count++;
    //         }
    //     }

    //     System.out.print(count);
    // }
}
