package middle;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * HJ70 矩阵乘法计算量估算
 * @author d3y1
 */
public class HJ70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution1(in);
            solution2(in);
        }
    }

    /**
     * stack
     * @param in
     */
    private static void solution1(Scanner in){
        int num = in.nextInt();

        // 矩阵行列数
        int[][] matrixRC = new int[num][2];
        for(int i=0; i<num; i++){
            matrixRC[i][0] = in.nextInt();
            matrixRC[i][1] = in.nextInt();
            in.nextLine();
        }

        String rule = in.nextLine();

        int result = 0;
        // 栈 矩阵行列数row column
        Stack<Integer> rcStack = new Stack<>();
        for(int i=0; i<rule.length(); i++){
            char ch = rule.charAt(i);
            if(ch == '('){
                continue;
            }else if(ch == ')'){
                // 右矩阵列数
                int RC = rcStack.pop();
                // 右矩阵行数
                int RR = rcStack.pop();
                // 左矩阵列数
                int LC = rcStack.pop();
                // 左矩阵行数
                int LR = rcStack.pop();

                result += LR * LC * RC;

                rcStack.push(LR);
                rcStack.push(RC);
            }else{
                rcStack.push(matrixRC[ch-'A'][0]);
                rcStack.push(matrixRC[ch-'A'][1]);
            }
        }

        System.out.println(result);
    }


    /**
     * stack + map
     */
    private static void solution2(Scanner in){
        int num = Integer.parseInt(in.nextLine());

        // 矩阵名->矩阵行列数
        HashMap<String, String> matrixMap = new HashMap<>();
        for(int i=0; i<num; i++){
            matrixMap.put(String.valueOf((char) ('A'+i)), in.nextLine());
        }

        String rule = in.nextLine();

        int result = 0;
        // 栈 矩阵名
        Stack<String> matrix = new Stack<>();
        for(int i=0; i<rule.length(); i++){
            char ch = rule.charAt(i);
            if(ch == '('){
                continue;
            }else if(ch == ')'){
                // 右矩阵
                String matrixR = matrix.pop();
                // 左矩阵
                String matrixL = matrix.pop();
                // 右矩阵行列数
                String[] matrixRRC = matrixMap.get(matrixR).split(" ");
                // 左矩阵行列数
                String[] matrixLRC = matrixMap.get(matrixL).split(" ");

                result += Integer.parseInt(matrixLRC[0]) * Integer.parseInt(matrixLRC[1]) * Integer.parseInt(matrixRRC[1]);

                matrixMap.put(matrixL+matrixR, matrixLRC[0]+" "+matrixRRC[1]);
                matrix.push(matrixL+matrixR);
            }else{
                matrix.push(String.valueOf(ch));
            }
        }

        System.out.println(result);
    }
}