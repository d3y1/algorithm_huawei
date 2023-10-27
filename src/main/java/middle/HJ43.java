package middle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * HJ43 迷宫问题
 * @author d3y1
 */
public class HJ43 {

    private static int[] dX = new int[]{0, 0, 1, -1};
    private static int[] dY = new int[]{1, -1, 0, 0};

    private static int row;
    private static int column;
    private static int[][] matrix;
    private static boolean[][] visited;
    private static Step[][] pre;

    private static Queue<Step> stepsQueue = new LinkedList<>();

    /**
     * dfs
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            row = in.nextInt();
            column = in.nextInt();

            matrix = new int[row][column];
            visited = new boolean[row][column];
            pre = new Step[row][column];
            for(int i=0; i<row; i++){
                for(int j=0; j<column; j++){
                    matrix[i][j] = in.nextInt();
                }
            }

            solutionDFS();
//            solutionBFS();
        }
    }

    /**
     * solution: DFS
     */
    private static void solutionDFS(){
        Step start = new Step(0, 0);

        dfs(start);

        printPath(row-1, column-1);
    }

    private static void dfs(Step curr){
        if(curr.x==row-1 && curr.y==column-1){
            return;
        }

        visited[curr.x][curr.y] = true;

        for(int i=0; i<4; i++){
            Step next = new Step(curr.x+dX[i], curr.y+dY[i]);
            if(canGo(next)){
                pre[next.x][next.y] = curr;
                dfs(next);
            }
        }
        visited[curr.x][curr.y] = false;
    }


    /**
     * solution: BFS
     */
    private static void solutionBFS(){
        Step start = new Step(0, 0);
        stepsQueue.add(start);

        bfs();

        printPath(row-1, column-1);
    }

    private static void bfs(){
        while (stepsQueue.size()!=0){
            Step curr = stepsQueue.poll();
            if(curr.x==row-1 && curr.y==column-1){
                break;
            }
            for(int i=0; i<4; i++){
                Step next = new Step(curr.x+dX[i], curr.y+dY[i]);
                if(canGo(next)){
                    stepsQueue.add(next);
                    pre[next.x][next.y] = curr;
                }
            }
            visited[curr.x][curr.y] = true;
        }
    }

    private static boolean canGo(Step next){
        // 越界
        if(next.x<0 || next.y<0 || next.x>=row || next.y>=column){
            return false;
        }

        // 墙壁
        if(matrix[next.x][next.y] == 1){
            return false;
        }

        // 已访问
        if(visited[next.x][next.y]){
            return false;
        }

        return true;
    }

    private static void printPath(int x, int y){
        if(x==0 && y==0){
            System.out.println("("+x+","+y+")");
            return;
        }

        Step previous = pre[x][y];
        printPath(previous.x, previous.y);

        System.out.println("("+x+","+y+")");
    }

    private static class Step {
        int x;
        int y;

        private Step(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
