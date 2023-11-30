package hardest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ28 素数伴侣
 * @author d3y1
 */
public class HJ28{
    private static List<Integer> odds = new ArrayList<>();
    private static List<Integer> evens = new ArrayList<>();
    private static boolean[] isEvenVisited;
    private static int[] evenMatchedOdd;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution(in);
        }
    }

    /**
     * 匈牙利算法
     * @param in
     */
    private static void solution(Scanner in){
        int N = in.nextInt();

        for(int i=0; i<N; i++){
            int num = in.nextInt();
            if(num%2 == 0){
                odds.add(num);
            }else{
                evens.add(num);
            }
        }

        // 当前序号对应的偶数匹配的素数伴侣(奇数)
        evenMatchedOdd = new int[evens.size()];

        int count = 0;
        for(Integer odd: odds){
            isEvenVisited = new boolean[evens.size()];
            if(find(odd)){
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * 递归 查找当前奇数的素数伴侣(偶数)
     * @param odd
     * @return
     */
    private static boolean find(int odd){
        for(int i=0; i<evens.size(); i++){
            if(!isEvenVisited[i] && isPrime(odd+evens.get(i))){
                isEvenVisited[i] = true;
                // 能让则让
                if(evenMatchedOdd[i]==0 || find(evenMatchedOdd[i])){
                    evenMatchedOdd[i] = odd;
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPrime(int num){
        for(int i=2; i<=(int)(Math.sqrt(num)); i++){
            if(num%i == 0){
                return false;
            }
        }

        return true;
    }
}