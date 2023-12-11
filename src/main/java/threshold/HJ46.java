package threshold;

import java.util.Scanner;

/**
 * HJ46 截取字符串
 * @author d3y1
 */
public class HJ46{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String input = in.nextLine();
            int k = in.nextInt();

            System.out.println(input.substring(0, k));
        }
    }
}
