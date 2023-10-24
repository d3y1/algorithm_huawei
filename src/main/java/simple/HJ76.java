package simple;

import java.util.Scanner;

public class HJ76 {

    /**
     * 输入m
     * 起始数n
     *
     * n+(n+2)+(n+4)+...+(n+2*(m-1)) = m^3
     * n*m+(2+4+...+2*(m-1)) = m^3
     * n*m+[(2+2*(m-1))*(m-1)]/2 = m^3
     * n*m+m*(m-1) = m^3
     * n+(m-1) = m^2
     * n = m^2 - (m-1) = m^2-m+1
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()){
            int m = in.nextInt();

            int n = (int)(Math.pow(m, 2)-m+1);

            for(int i=1; i<m; i++){
                System.out.print(n+"+");
                n += 2;
            }
            System.out.print(n);
        }
    }
}
