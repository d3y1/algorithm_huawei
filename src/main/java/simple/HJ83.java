package simple;

import java.util.Scanner;

public class HJ83 {

    private static final int BASE = 9;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();

            // 1
            if(1<=m&&m<=BASE && 1<=n&&n<=BASE){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            // 2
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            if(0<=x1&&x1<m && 0<=y1&&y1<n && 0<=x2&&x2<m && 0<=y2&&y2<n){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            // 3
            int x = in.nextInt();
            if(m<BASE && 0<=x&&x<m){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            // 4
            int y = in.nextInt();
            if(n<BASE && 0<=y&&y<n){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            // 5
            int indexX = in.nextInt();
            int indexY = in.nextInt();
            if(0<=indexX&&indexX<m && 0<=indexY&&indexY<n){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
        }
    }
}
