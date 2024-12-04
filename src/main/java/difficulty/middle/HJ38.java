package difficulty.middle;

import java.util.Scanner;

/**
 * HJ38 求小球落地5次后所经历的路程和第5次反弹的高度
 * @author d3y1
 */
public class HJ38 {

    /**
     * 循环
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            double h = in.nextDouble();
            double temp = h/2;//弹跳多高
            for(int i=1;i<5;i++){
                h += temp * 2;
                temp = temp/2;
            }
            System.out.println(h);
            System.out.println(temp);
        }
    }



//    /**
//     * 数学公式 等比数列
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()){
//            Integer height = in.nextInt();
//
//            double total = height*(Math.pow(2, 5)-1)/Math.pow(2, 3)-height;
//            double finalHeight = height/Math.pow(2, 5);
//
//            // System.out.printf("%.6f", total);
//            System.out.println(total);
//            // System.out.println();
//            // System.out.printf("%.6f", finalHeight);
//            System.out.println(finalHeight);
//        }
//    }
}
