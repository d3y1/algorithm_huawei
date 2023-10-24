package simple;

import java.util.Scanner;

public class HJ56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int count = 0;

        for(int i=1; i<=num; i++){
            int result = 0;
            for(int j=1; j<i; j++){
                if(i%j == 0){
                    result += j;
                }
            }
            if(i == result){
                count++;
            }
        }

        System.out.print(count);
    }
}
