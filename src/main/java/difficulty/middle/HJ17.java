package difficulty.middle;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HJ17 坐标移动
 * @author d3y1
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        String[] moves = input.split(";");

        int x = 0;
        int y = 0;

//        String regex = "[ADWS]\\d{1}|[ADWS][1-9]\\d{1}";
        String regex = "[ADWS][0-9]{1,2}";
        Pattern pattern = Pattern.compile(regex);

        for(int i=0; i<moves.length; i++){
            String move = moves[i].trim();
            int moveLen= move.length();
            if(moveLen==2 || moveLen==3){
                Matcher matcher = pattern.matcher(move);
                if(matcher.matches()){
                    Character direction = move.charAt(0);
                    Integer steps = Integer.valueOf(move.substring(1));

                    switch (direction){
                        case 'A':  {x -= steps; break;}
                        case 'D':  {x += steps; break;}
                        case 'W':  {y += steps; break;}
                        case 'S':  {y -= steps; break;}
                        default: break;
                    }
                }
            }
        }

        System.out.print(x+","+y);
    }
}
