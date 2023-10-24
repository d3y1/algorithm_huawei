package middle;

import java.util.Scanner;

/**
 * HJ32 密码截取
 * @author d3y1
 */
public class HJ32 {

    /**
     * 动态规划
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String input = in.nextLine();

            char[] chars = input.toCharArray();
            int len = input.length();
            int result = 1;
            int[][] dp = new int[len+1][len+1];

            for(int i=0; i<len; i++){
                dp[i][i] = 1;
            }

            for(int i=0; i<len-1; i++){
                if(chars[i] == chars[i+1]){
                    dp[i][i+1] = 2;
                }
            }

            for(int k=2; k<len; k++){
                for(int i=0; i+k<len; i++){
                    // 左右两边字符相同 且 之间子串为回文串
                    if(chars[i] == chars[i+k] && dp[i+1][i+k-1]>=1){
                        // 回文串 长度+2
                        dp[i][i+k] = dp[i+1][i+k-1]+2;
                    }else{
                        // 非回文串
                        dp[i][i+k] = 0;
                    }

                    result = Math.max(result, dp[i][i+k]);
                }
            }

            System.out.println(result);
        }
    }



//    /**
//     * reverse() time exceed
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()){
//            String input = in.nextLine();
//
//            int len = input.length();
//            int result = 1;
//
//            for(int i=0; i<len; i++){
//                for(int j=len; j>i; j--){
//                    if(isReverse(input.substring(i,j))){
//                        result = Math.max(result, j-i);
//                    }
//                }
//            }
//
//            System.out.print(result);
//        }
//    }
//
//    private static boolean isReverse(String str){
//
//        return str.equals(new StringBuilder(str).reverse().toString());
//    }
}
