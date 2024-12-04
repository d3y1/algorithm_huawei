package difficulty.middle;

import java.util.Scanner;

/**
 * HJ90 合法IP
 * @author d3y1
 */
public class HJ90{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String ip = in.nextLine().trim();

            // (0-255).(0-255).(0-255).(0-255)
            // (0-255) -> (([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))
            String pattern = "((([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\\.){3}(([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))";

            boolean isValid = ip.matches(pattern);

            if(isValid){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}