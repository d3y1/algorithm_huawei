package difficulty.middle;

import java.util.Scanner;

/**
 * HJ33 整数与IP地址间的转换
 * @author d3y1
 */
public class HJ33 {

    private static final int N = 4;

    /**
     * 256进制
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String res = convert(str);
            System.out.println(res);
        }
    }

    public static String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < N; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }



//    /**
//     * 二进制
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()){
//            String ipStr = in.nextLine();
//            Long ip = in.nextLong();
//
//            Long ipLong = ipStrToLong(ipStr);
//            System.out.println(ipLong);
//
//            String ipToStr = longToIpStr(ip);
//            System.out.println(ipToStr);
//        }
//    }
//
//    private static Long ipStrToLong(String ipStr){
//        String[] segment = ipStr.split("\\.");
//
//        StringBuilder sb = new StringBuilder();
//        for(String str: segment){
//            String binaryStr = Integer.toBinaryString(Integer.parseInt(str));
//            switch (binaryStr.length()){
//                case 1: {sb.append("0000000").append(binaryStr); break;}
//                case 2: {sb.append("000000").append(binaryStr); break;}
//                case 3: {sb.append("00000").append(binaryStr); break;}
//                case 4: {sb.append("0000").append(binaryStr); break;}
//                case 5: {sb.append("000").append(binaryStr); break;}
//                case 6: {sb.append("00").append(binaryStr); break;}
//                case 7: {sb.append("0").append(binaryStr); break;}
//                case 8: {sb.append(binaryStr); break;}
//                default: break;
//            }
//        }
//
//        return Long.parseLong(sb.toString(), 2);
//    }
//
//    private static String longToIpStr(Long ip){
//        String binaryStr = Long.toBinaryString(ip);
//        int len = binaryStr.length();
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i=0, j=len%8; j<=len; i=j, j+=8){
//            if(j == 0){
//                j = 8;
//            }
//            int segmentInt = Integer.parseInt(binaryStr.substring(i, j), 2);
//            if(j < len){
//                sb.append(segmentInt).append(".");
//            }else{
//                sb.append(segmentInt);
//            }
//        }
//
//        return sb.toString();
//    }
}
