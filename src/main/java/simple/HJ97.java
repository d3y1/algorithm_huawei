package simple;

import java.util.Scanner;

public class HJ97 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.hasNextLine();

        int posCount = 0;
        int negCount = 0;
        float posTotal = 0;

        for(int i=1; i<=n; i++){
            int num = in.nextInt();
            if(num > 0){
                posCount++;
                posTotal += num;
            }else if(num < 0){
                negCount++;
            }
        }


        System.out.print(negCount+" ");
        if(posCount == 0){
            System.out.print("0.0");
        }else{
            float average = posTotal/posCount;
            System.out.printf("%.1f", average);
        }
    }
}
