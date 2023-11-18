package hard;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * HJ3 明明的随机数
 * @author d3y1
 */
public class HJ3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution1(in);
            solution2(in);
        }
    }


    /**
     * TreeSet
     * @param in
     */
    private static void solution1(Scanner in){
        int N = in.nextInt();

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=1; i<=N; i++){
            set.add(in.nextInt());
        }

        for(Integer num: set){
            System.out.println(num);
        }
    }


    /**
     * 位图
     * @param in
     */
    private static void solution2(Scanner in){
        int N = in.nextInt();

        int max = 500;
        int[] nums = new int[max+1];

        for(int i=1; i<=N; i++){
            nums[in.nextInt()] = 1;
        }

        for(int i=1; i<=max; i++){
            if(nums[i] == 1){
                System.out.println(i);
            }
        }
    }
}