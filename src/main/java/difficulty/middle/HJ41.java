package difficulty.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * HJ41 称砝码
 * @author d3y1
 */
public class HJ41 {

    /**
     * set
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            Integer num = in.nextInt();

            int[] weight = new int[num];
            for(int i=0; i<num; i++){
                weight[i] = in.nextInt();
            }

            int[] quantity = new int[num];
            for(int i=0; i<num; i++){
                quantity[i] = in.nextInt();
            }

            HashSet<Integer> amountSet = new HashSet<>();
            amountSet.add(0);

            for(int i=0; i<num; i++){
                List<Integer> amountList = new ArrayList<>(amountSet);
                for(Integer amount: amountList){
                    for(int j=1; j<=quantity[i]; j++) {
                        int newAmount = amount + weight[i] * j;
                        if (!amountSet.contains(newAmount)) {
                            amountSet.add(newAmount);
                        }
                    }
                }
            }

            System.out.println(amountSet.size());
        }
    }



//    /**
//     * 二进制 time exceed
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()){
//            Integer num = in.nextInt();
//
//            int[] weight = new int[num];
//            for(int i=0; i<num; i++){
//                weight[i] = in.nextInt();
//            }
//
//            int[] quantity = new int[num];
//            for(int i=0; i<num; i++){
//                quantity[i] = in.nextInt();
//            }
//
//            StringBuilder sb = new StringBuilder();
//            int totalQuantity = 0;
//            for(int i=0; i<num; i++){
//                totalQuantity += quantity[i];
//                for(int j=0; j<quantity[i]; j++){
//                    sb.append(weight[i]).append("-");
//                }
//            }
//
//            HashSet<Integer> amountSet = new HashSet<>();
//            String[] weights = sb.toString().split("-");
//            int sbLen = weights.length;
//            for(int i=0; i<Math.pow(2, totalQuantity); i++){
//                String binaryStr = Integer.toBinaryString(i);
//                int index = binaryStr.length();
//                int amount = 0;
//                for(int j=index-1,k=sbLen-1; j>=0; j--,k--){
//                    amount += Integer.parseInt(String.valueOf(binaryStr.charAt(j))) * Integer.parseInt(weights[k]);
//                }
//                amountSet.add(amount);
//            }
//
//            System.out.println(amountSet.size());
//        }
//    }
}
