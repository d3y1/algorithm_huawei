package difficulty.simple;

import java.util.Scanner;

public class HJ105 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nonNegCount = 0;
        int negCount = 0;
        float total = 0;

        while (in.hasNextInt()){
            int num = in.nextInt();
            if(num >= 0){
                nonNegCount++;
                total += num;
            }else {
                negCount++;
            }
        }


        System.out.println(negCount);
        if(nonNegCount == 0){
            System.out.print("0.0");
        }else{
            float average = total/nonNegCount;
            System.out.printf("%.1f", average);
        }
    }
}
