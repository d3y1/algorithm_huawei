package difficulty.threshold;

import java.util.Scanner;

/**
 * HJ7 取近似值
 * @author d3y1
 */
public class HJ7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            double num = in.nextDouble();
            System.out.println(num+0.5);
        }
    }



//    /**
//     * Math.round()
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()){
//            double num = in.nextDouble();
//            System.out.println(Math.round(num));
//        }
//    }
}
