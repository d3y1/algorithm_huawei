package middle;

import java.util.Scanner;

/**
 * HJ55 挑7
 * @author d3y1
 */
public class HJ55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int num = in.nextInt();
            int count = num/7;

            for(int i=8; i<=num; i++){
                if(String.valueOf(i).contains("7")){
                    if(i%7 != 0){
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
